package com.qianxun.admin.controller;

import com.qianxun.admin.model.dto.sysDept.request.*;
import com.qianxun.admin.model.entity.SysDept;
import com.qianxun.admin.service.SysDeptService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * 部门管理
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
@RestController
@RequestMapping("SysDept")
public class SysDeptController extends BaseController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysDeptQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysDeptService.findAllSysDepts());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysDeptAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysDept sysDept = BeanMapper.map(input,SysDept.class);
        jsonResult.setData(sysDeptService.addSysDept(sysDept));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysDeptDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysDeptService.deleteSysDept(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysDeptUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysDept sysDept = BeanMapper.map(input,SysDept.class);
        jsonResult.setData(sysDeptService.editSysDept(sysDept));
        return jsonResult;
    }
}