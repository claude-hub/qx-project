package com.qianxun.generator.controller;


import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.generator.service.GeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 代码生成器
 */
@RestController
@RequestMapping(value = "api/admin/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

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
    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String[] tableNames = new String[]{};
//        String tables = request.getParameter("tables");
//        tableNames = JSON.parseArray(tables).toArray(tableNames);
        String[] tableNames = {"sys_user","sys_role","sys_user_role","sys_menu","sys_role_menu","sys_dept","sys_role_dept"};
        byte[] data = generatorService.generatorCode(tableNames);

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"qianxun.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}