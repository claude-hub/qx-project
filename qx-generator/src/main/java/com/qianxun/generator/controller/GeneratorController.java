package com.qianxun.generator.controller;

import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.generator.service.GeneratorService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 */
@RestController
@AllArgsConstructor
public class GeneratorController {
    private final GeneratorService generatorService;

    /**
     * 获取数据库所有表
     * @return
     */
    @GetMapping("/tables")
    public JSONResult tables(){
        JSONResult data = new JSONResult();
        data.setData(generatorService.getTables());
        return data;
    }

    /**
     * 生成代码
     */
    @GetMapping("/code/{type}/{tables}")
    public void code(@Valid @PathVariable("type") int type,@Valid @PathVariable("tables") String[] tables,
                     HttpServletResponse response) throws IOException {
//        String[] tableNames = {"sys_dept","sys_menu","sys_role_menu","sys_user_menu"
//        ,"sys_role_lang","sys_role","sys_user","sys_lang","sys_menu_lang"
//        ,"sys_dept_role","sys_dept_lang"};

        byte[] data;
        if (type == 0){
            data = generatorService.generatorCode(tables, getBaseTemplates());
        }else if(type == 1){
            data = generatorService.generatorCode(tables, getTemplates());
        } else {
            return;
        }
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"qx-project.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }

    private static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("temp/model/entity/Entity.java.vm");
        templates.add("temp/model/entity/LangEntity.java.vm");
        templates.add("temp/Mapper.java.vm");
        templates.add("temp/Mapper.xml.vm");
        templates.add("temp/LangMapper.java.vm");
        templates.add("temp/Controller.java.vm");
        templates.add("temp/Service.java.vm");
        templates.add("temp/ServiceImpl.java.vm");
        templates.add("temp/LangService.java.vm");
        templates.add("temp/LangServiceImpl.java.vm");
        templates.add("temp/GrpcClient.java.vm");
        templates.add("temp/GrpcService.java.vm");
        templates.add("temp/proto.vm");
        templates.add("temp/model/dto/request/AddInputDTO.java.vm");
        templates.add("temp/model/dto/request/DeleteInputDTO.java.vm");
        templates.add("temp/model/dto/request/QueryInputDTO.java.vm");
        templates.add("temp/model/dto/request/UpdateInputDTO.java.vm");
        templates.add("temp/model/dto/request/SearchByIdDTO.java.vm");
        templates.add("temp/model/dto/response/ResponseDTO.java.vm");
        templates.add("temp/model/dto/extend/ExtendDTO.java.vm");
        return templates;
    }

    private static List<String> getBaseTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("temp/model/entity/Entity.java.vm");
        templates.add("temp/model/dto/request/DeleteInputDTO.java.vm");

        templates.add("template/base/BaseController.java.vm");
        templates.add("template/base/BaseGrpcClient.java.vm");
        templates.add("template/base/BaseProto.vm");
        templates.add("template/base/BaseMapper.java.vm");
        templates.add("template/base/BaseService.java.vm");
        templates.add("template/base/BaseServiceImpl.java.vm");
        templates.add("template/base/BaseGrpcService.java.vm");
        templates.add("template/base/dto/BaseAddInputDTO.java.vm");
        templates.add("template/base/dto/BaseQueryInputDTO.java.vm");
        templates.add("template/base/dto/BaseUpdateInputDTO.java.vm");
        templates.add("template/base/dto/BaseResponseDTO.java.vm");
        return templates;
    }
}
