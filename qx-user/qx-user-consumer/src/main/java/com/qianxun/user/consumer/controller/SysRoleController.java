package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleAddInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleDeleteInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleUpdateInputDTO;
import com.qianxun.admin.api.dto.sysRole.response.SysRoleResponseDTO;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.admin.api.utils.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysRole.SysRoleOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysRoleClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Cloudy
 * Date: 2019/5/7 22:12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/sysRole")
public class SysRoleController {
    private final GrpcSysRoleClient grpcSysRoleClient;

    @GetMapping(value = "/{id}")
    public JSONResult getRoleId(@Valid SearchByIdInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(inputDTO, SysRoleOuterClass.ByIdReq.class);
        SysRole sysRole = grpcSysRoleClient.getRoleById(getByIdReq);
        result.setData(sysRole.getId() != null ? sysRole : "");
        return result;
    }

    @GetMapping(value = "/list")
    public JSONResult getRoleList(@Valid SysRoleQueryInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(inputDTO, SysRoleOuterClass.GetListReq.class);
        SysRoleResponseDTO responseDTO = grpcSysRoleClient.getRoleList(getListReq);
        result.setData(responseDTO.getSysRole());
        result.setTotalCount(responseDTO.getTotal());
        return result;
    }

    @PostMapping(value = "/add")
    public JSONResult addRole(@Valid SysRoleAddInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.SysRole sysRole = ProtoBufUtils.toProtoBuffer(inputDTO, SysRoleOuterClass.SysRole.class);
        result.setData(grpcSysRoleClient.addRole(sysRole));
        return result;
    }

    @PutMapping(value = "/update")
    public JSONResult updateRole(@Valid SysRoleUpdateInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.SysRole sysRole = ProtoBufUtils.toProtoBuffer(inputDTO, SysRoleOuterClass.SysRole.class);
        result.setData(grpcSysRoleClient.updateRole(sysRole));
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public JSONResult deleteRole(@Valid SysRoleDeleteInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(inputDTO, SysRoleOuterClass.ByIdReq.class);
        result.setData(grpcSysRoleClient.deleteRole(req));
        return result;
    }
}
