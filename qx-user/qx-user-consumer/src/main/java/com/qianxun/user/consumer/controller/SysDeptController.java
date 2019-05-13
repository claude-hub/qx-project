package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.sysDept.request.*;
import com.qianxun.admin.api.dto.sysDept.response.SysDeptResponseDTO;
import com.qianxun.admin.api.dto.extend.SysDeptDTO;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysDept.SysDeptOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysDeptClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author Cloudy
 *  */
@RestController
@AllArgsConstructor
@RequestMapping("/api/sysDept")
public class SysDeptController {
    private final GrpcSysDeptClient grpcSysDeptClient;

    /**
    * selectById
    * @param input
    * @return
    */
    @GetMapping(value = "/{id}")
    public JSONResult getSysDeptId(@Valid SysDeptSearchByIdDTO input) {
        JSONResult result = new JSONResult();
        SysDeptOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(input, SysDeptOuterClass.ByIdReq.class);
        SysDeptDTO sysDeptDTO = grpcSysDeptClient.getSysDeptById(getByIdReq);
        result.setData(sysDeptDTO.getId() != null ? sysDeptDTO : "");
        return result;
    }

    /**
    * 根据语言分页查询
    * @param input
    * @return
    */
    @GetMapping(value = "/list")
    public JSONResult getSysDeptList(@Valid SysDeptQueryInputDTO input) {
        JSONResult result = new JSONResult();
        SysDeptOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(input, SysDeptOuterClass.GetListReq.class);
        SysDeptResponseDTO responseDTO = grpcSysDeptClient.getSysDeptList(getListReq);
        result.setData(responseDTO.getSysDepts());
        result.setTotalCount(responseDTO.getTotal());
        return result;
    }

    /**
    * 根据语言新增
    * @param input
    * @return
    */
    @PostMapping(value = "/add")
    public JSONResult addSysDept(@Valid SysDeptAddInputDTO input) {
        JSONResult result = new JSONResult();
        SysDeptOuterClass.BaseSysDept baseSysDept = ProtoBufUtils.toProtoBuffer(input, SysDeptOuterClass.BaseSysDept.class);
        result.setData(grpcSysDeptClient.addSysDept(baseSysDept));
        return result;
    }

    /**
    * 更新
    * @param input
    * @return
    */
    @PutMapping(value = "/update")
    public JSONResult updateSysDept(@Valid SysDeptUpdateInputDTO input) {
        JSONResult result = new JSONResult();
        SysDeptOuterClass.SysDept sysDept = ProtoBufUtils.toProtoBuffer(input, SysDeptOuterClass.SysDept.class);
        result.setData(grpcSysDeptClient.updateSysDept(sysDept));
        return result;
    }

    /**
    * 逻辑删除
    * @param input
    * @return
    */
    @DeleteMapping(value = "/{id}")
    public JSONResult deleteSysDept(@Valid SysDeptDeleteInputDTO input) {
        JSONResult result = new JSONResult();
        SysDeptOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(input, SysDeptOuterClass.ByIdReq.class);
        result.setData(grpcSysDeptClient.deleteSysDept(req));
        return result;
    }
}
