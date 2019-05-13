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
    //src/main/java/com/qianxun/
    private static final String BASE_PACKAGE = "src" + File.separator + "main" + File.separator + "java"
            + File.separator + "com" + File.separator + "qianxun" + File.separator;
    //admin/api/
    private static final String API = "admin" + File.separator + "api" + File.separator;
    //dto/
    private static final String DTO = "dto" + File.separator;
    //request/
    private static final String REQUEST = "request" + File.separator;
    //user/consumer/
    private static final String CONSUMER = "user" + File.separator + "consumer" + File.separator;
    //admin/provider/
    private static final String PROVIDER = "admin" + File.separator + "provider" + File.separator;
    //src/main/proto/
    private static final String PROTO = "src" + File.separator + "admin" + File.separator + "proto" + File.separator;
    //mapper.xml
    private static final String MAPPER = "src" + File.separator + "admin" + File.separator + "resources" + File.separator;
    //qx-use/
    private static final String QX_USER = "qx-user" + File.separator;
    //qx-user-api/
    private static final String QX_USER_API = "qx-user-api" + File.separator;
    //qx-user-provider/
    private static final String QX_USER_PROVIDER = "qx-user-provider" + File.separator;
    //qx-user-consumer/
    private static final String QX_USER_CONSUMER = "qx-user-consumer" + File.separator;
    //qx-user-grpc-lib
    private static final String QX_USER_GRPC_LIB = "qx-user-grpc-lib" + File.separator;


    private static String getFileName(String template, String className, String classname, String tableName, String moduleName) {
        //qx-user/qx-user-api/src/main/java/com/qianxun/admin/api/
        String apiPath = QX_USER + QX_USER_API + BASE_PACKAGE + API;
        if (template.contains("BaseAddInputDTO.java.vm")) {
            //qx-user/qx-user-api/src/main/java/com/qianxun/admin/api/dto/{className}/request/AddInputDTO.java
            return apiPath + DTO + classname + File.separator + REQUEST + className + "AddInputDTO.java";
        }
        if (template.contains("BaseQueryInputDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator + REQUEST + className + "QueryInputDTO.java";
        }
        if (template.contains("BaseUpdateInputDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator + REQUEST + className + "UpdateInputDTO.java";
        }
        if (template.contains("BaseResponseDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator +"response" + File.separator + className + "ResponseDTO.java";
        }
        if (template.contains("ExtendDTO.java.vm")) {
            return apiPath + DTO + "extend" + File.separator + className + "DTO.java";
        }
        if (template.contains("LangEntity.java.vm")) {
            return apiPath + "entity" + File.separator + className + "Lang.java";
        }
        if (template.contains("Entity.java.vm")) {
            return apiPath + "entity" + File.separator + className + ".java";
        }
        if (template.contains("SearchByIdDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator + REQUEST + className + "SearchByIdDTO.java";
        }
        if (template.contains("AddInputDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator + REQUEST + className + "AddInputDTO.java";
        }
        if (template.contains("DeleteInputDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator + REQUEST + className + "DeleteInputDTO.java";
        }
        if (template.contains("QueryInputDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator + REQUEST + className + "QueryInputDTO.java";
        }
        if (template.contains("UpdateInputDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator + REQUEST + className + className + "UpdateInputDTO.java";
        }
        if (template.contains("ResponseDTO.java.vm")) {
            return apiPath + DTO + classname + File.separator + REQUEST + className + className + "ResponseDTO.java";
        }

        //服务提供者
        String providerPath = QX_USER + QX_USER_PROVIDER + BASE_PACKAGE + PROVIDER;
        if (template.contains("BaseGrpcService.java.vm")) {
            return providerPath + "grpc" + File.separator + "service" + File.separator + "Grpc" + className + "Service.java";
        }
        if (template.contains("BaseMapper.java.vm")) {
            return providerPath + "mapper" + File.separator + className + "Mapper.java";
        }
        if (template.contains("BaseService.java.vm")) {
            return providerPath + "service" + File.separator + className + "Service.java";
        }
        if (template.contains("BaseServiceImpl.java.vm")) {
            return providerPath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }
        if (template.contains("LangMapper.java.vm")) {
            return providerPath + "mapper" + File.separator + className + "LangMapper.java";
        }
        if (template.contains("Mapper.java.vm")) {
            return providerPath + "mapper" + File.separator + className + "Mapper.java";
        }
        if (template.contains("GrpcService.java.vm")) {
            return providerPath + "grpc" + File.separator + "service" + File.separator + "Grpc" + className + "Service.java";
        }
        if (template.contains("LangService.java.vm")) {
            return providerPath + "service" + File.separator + className + "LangService.java";
        }
        if (template.contains("LangServiceImpl.java.vm")) {
            return providerPath + "service" + File.separator + "impl" + File.separator + className + "LangServiceImpl.java";
        }
        if (template.contains("Service.java.vm")) {
            return providerPath + "service" + File.separator + className + "Service.java";
        }
        if (template.contains("ServiceImpl.java.vm")) {
            return providerPath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Mapper.xml.vm")) {
            return QX_USER + QX_USER_PROVIDER + MAPPER + "mapper" + File.separator + moduleName + File.separator + className + "Mapper.xml";
        }

        //消费者
        String consumerPath = QX_USER + QX_USER_CONSUMER + BASE_PACKAGE + CONSUMER;
        if (template.contains("BaseController.java.vm")) {
            return consumerPath + "controller" + File.separator + className + "Controller.java";
        }
        if (template.contains("BaseGrpcClient.java.vm")) {
            return consumerPath + "grpc" + File.separator + "client" + File.separator + "Grpc" + className + "Client.java";
        }
        if (template.contains("Controller.java.vm")) {
            return consumerPath + "controller" + File.separator + className + "Controller.java";
        }
        if (template.contains("GrpcClient.java.vm")) {
            return consumerPath + "grpc" + File.separator + "client" + File.separator + "Grpc" + className + "Client.java";
        }

        // grpc-lib
        String protoPath = QX_USER + QX_USER_GRPC_LIB + PROTO;
        if (template.contains("BaseProto.vm")) {
            return protoPath + tableName + ".proto";
        }
        if (template.contains("proto.vm")) {
            return protoPath + tableName + ".proto";
        }
        return null;
    }
}
