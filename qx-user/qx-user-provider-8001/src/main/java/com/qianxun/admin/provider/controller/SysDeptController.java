package com.qianxun.admin.provider.controller;

import com.qianxun.admin.provider.model.dto.sysDept.request.*;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.admin.provider.service.SysDeptService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 *
 *
 * @author cloudy
 * @date 2019-04-27 14:07:32
 */
@RestController
@RequestMapping("/api/admin/sysDept")
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
