package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.base.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.*;
import com.qianxun.admin.api.dto.sysRole.response.SysRoleResponseDTO;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysRole.SysRoleOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysRoleClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author Cloudy
 *  */
@RestController
@AllArgsConstructor
@RequestMapping("/sysRole")
public class SysRoleController {
    private final GrpcSysRoleClient grpcSysRoleClient;

    /**
    * selectById
    * @param input
    * @return
    */
    @GetMapping(value = "/{id}")
    public JSONResult getSysRoleId(@Valid SearchByIdInputDTO input) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(input, SysRoleOuterClass.ByIdReq.class);
        SysRole sysRole = grpcSysRoleClient.getSysRoleById(getByIdReq);
        result.setData(sysRole.getId() != null ? sysRole : "");
        return result;
    }

    /**
    * 根据语言分页查询
    * @param input
    * @return
    */
    @GetMapping(value = "/list")
    public JSONResult getSysRoleList(@Valid SysRoleQueryInputDTO input) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(input, SysRoleOuterClass.GetListReq.class);
        SysRoleResponseDTO responseDTO = grpcSysRoleClient.getSysRoleList(getListReq);
        result.setData(responseDTO.getSysRoles());
        result.setTotalCount(responseDTO.getTotal());
        return result;
    }

    /**
    * 根据语言新增
    * @param input
    * @return
    */
    @PostMapping(value = "/add")
    public JSONResult addSysRole(@Valid SysRoleAddInputDTO input) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.BaseSysRole baseSysRole = ProtoBufUtils.toProtoBuffer(input, SysRoleOuterClass.BaseSysRole.class);
        result.setData(grpcSysRoleClient.addSysRole(baseSysRole));
        return result;
    }

    /**
    * 更新
    * @param input
    * @return
    */
    @PutMapping(value = "/update")
    public JSONResult updateSysRole(@Valid SysRoleUpdateInputDTO input) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.SysRole sysRole = ProtoBufUtils.toProtoBuffer(input, SysRoleOuterClass.SysRole.class);
        result.setData(grpcSysRoleClient.updateSysRole(sysRole));
        return result;
    }

    /**
    * 逻辑删除
    * @param input
    * @return
    */
    @PostMapping(value = "/delete")
    public JSONResult deleteSysRole(@Valid SysRoleDeleteInputDTO input) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(input, SysRoleOuterClass.ByIdReq.class);
        result.setData(grpcSysRoleClient.deleteSysRole(req));
        return result;
    }

    /**
     * 添加角色权限
     * @param input
     * @return
     */
    @PostMapping(value = "/rolePermissions")
    public JSONResult addRolePermissions(@Valid SysRolePermissionDTO input) {
        JSONResult result = new JSONResult();
        SysRoleOuterClass.RolePermsReq req = ProtoBufUtils.toProtoBuffer(input, SysRoleOuterClass.RolePermsReq.class);
        result.setData(grpcSysRoleClient.addRolePerms(req));
        return result;
    }
}
