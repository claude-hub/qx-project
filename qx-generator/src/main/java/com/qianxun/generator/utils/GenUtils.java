package com.qianxun.generator.utils;

import com.qianxun.generator.entity.ColumnEntity;
import com.qianxun.generator.entity.TableEntity;
import com.qianxun.generator.utils.exception.RRException;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器   工具类
 */
public class GenUtils {
    /**
     * 生成代码
     */
    public static void generatorCode(Map<String, String> table,
                                     List<Map<String, String>> columns,
                                     List<String> templates,
                                     ZipOutputStream zip) {
        //配置信息
        Configuration config = getConfig();
        boolean hasBigDecimal = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));
        tableEntity.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columsList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            //把数据库的jdbc小写类型，如int,varchar
            columnEntity.setDataType(column.get("dataType"));
            //把数据库的jdbc类型转化为大写，如VARCHAR
            columnEntity.setDataUpperCaseType(column.get("dataType").toUpperCase());
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));
            columnEntity.setNullable(column.get("isNullable"));
            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

            //jdbc的大写类型，转化为java的包含包名的类型，如INT=>java.lang.Integer
            String attrAllType = config.getString(columnEntity.getDataUpperCaseType(), "unknowType");
            columnEntity.setAttrAllType(attrAllType);
            //列的数据类型，转换成Java类型(配置文件读)
            String attrType = config.getString(columnEntity.getDataType(), "unknowType");
            columnEntity.setAttrType(attrType);
            if (!hasBigDecimal && attrAllType.equals("java.math.BigDecimal")
                    || !hasBigDecimal && attrType.equals("BigDecimal")) {
                hasBigDecimal = true;
            }
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }
            columsList.add(columnEntity);
        }
        tableEntity.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        String mainPath = config.getString("mainPath");
        mainPath = StringUtils.isBlank(mainPath) ? "com.qianxun" : mainPath;

        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("mainPath", mainPath);
        map.put("package", config.getString("package"));
        map.put("moduleName", config.getString("moduleName"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);

        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);

            try {
                //添加到zip
                String name = getFileName(template, tableEntity.getClassName(),
                        tableEntity.getClassname(),
                        tableEntity.getTableName(),
                        config.getString("moduleName"));
                zip.putNextEntry(new ZipEntry(name));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                zip.closeEntry();
            } catch (IOException e) {
                throw new RRException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }
    }

    /**
     * 获取配置信息
     */
    private static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new RRException("获取配置文件失败，", e);
        }
    }

    /**
     * 表名转换成Java类名
     */
    private static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    /**
     * 列名转换成Java属性名
     */
    private static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 获取文件名
     */
    private static String getFileName(String template, String className, String classname, String tableName, String moduleName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        if (template.contains("Controller.java.vm")) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }
        if (template.contains("ExtendDTO.java.vm")) {
            return packagePath + "model" + File.separator + "extend" + File.separator + className + "DTO.java";
        }
        if (template.contains("LangEntity.java.vm")) {
            return packagePath + "model" + File.separator + "entity" + File.separator + className + "Lang.java";
        }
        if (template.contains("Entity.java.vm")) {
            return packagePath + "model" + File.separator + "entity" + File.separator + className + ".java";
        }
        if (template.contains("LangMapper.java.vm")) {
            return packagePath + "mapper" + File.separator + className + "LangMapper.java";
        }
        if (template.contains("Mapper.java.vm")) {
            return packagePath + "mapper" + File.separator + className + "Mapper.java";
        }
        if (template.contains("Mapper.xml.vm")) {
            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Mapper.xml";
        }
        if (template.contains("GrpcClient.java.vm")) {
            return packagePath + "grpc" + File.separator + "client" + File.separator + "Grpc"+ className + "Client.java";
        }
        if (template.contains("GrpcService.java.vm")) {
            return packagePath + "grpc" + File.separator + "service" + File.separator  + "Grpc"+ className + "Service.java";
        }
        if (template.contains("LangService.java.vm")) {
            return packagePath + "service" + File.separator + className + "LangService.java";
        }
        if (template.contains("LangServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "LangServiceImpl.java";
        }
        if (template.contains("Service.java.vm")) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }
        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }
        if (template.contains("AddInputDTO.java.vm")) {
            return packagePath + "model" + File.separator + "dto" + File.separator + classname + File.separator + "request" + File.separator + className + "AddInputDTO.java";
        }
        if (template.contains("DeleteInputDTO.java.vm")) {
            return packagePath + "model" + File.separator  + "dto" + File.separator + classname + File.separator + "request" + File.separator + className + "DeleteInputDTO.java";
        }
        if (template.contains("QueryInputDTO.java.vm")) {
            return packagePath + "model" + File.separator  + "dto" + File.separator + classname + File.separator + "request" + File.separator + className + "QueryInputDTO.java";
        }
        if (template.contains("UpdateInputDTO.java.vm")) {
            return packagePath + "model" + File.separator  + "dto" + File.separator + classname + File.separator + "request" + File.separator + className + "UpdateInputDTO.java";
        }
        if (template.contains("ResponseDTO.java.vm")) {
            return packagePath + "model" + File.separator  + "dto" + File.separator + classname + File.separator + "response" + File.separator + className + "ResponseDTO.java";
        }
        if (template.contains("proto.vm")) {
            return packagePath + "proto" + File.separator + tableName + ".proto";
        }
        return null;
    }
}
