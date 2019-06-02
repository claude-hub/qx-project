package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.base.RequestDTO;
import com.qianxun.admin.api.dto.base.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.dto.sysUser.request.*;
import com.qianxun.admin.api.dto.sysUser.response.SysUserResponseDTO;
import com.qianxun.admin.api.entity.SysUser;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysUser.SysUserOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysUserClient;
import com.qianxun.user.consumer.utils.SecurityBeanUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.stream.Collectors;

/**
 * @author Cloudy
 *  */
@RestController
@AllArgsConstructor
@RequestMapping("/sysUser")
public class SysUserController {
    private final GrpcSysUserClient grpcSysUserClient;

    /**
    * selectById
    * @param input
    * @return
    */
    @GetMapping(value = "/{id}")
    public JSONResult getSysUserId(@Valid SearchByIdInputDTO input) {
        JSONResult result = new JSONResult();
        SysUserOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(input, SysUserOuterClass.ByIdReq.class);
        SysUser sysUser = grpcSysUserClient.getSysUserById(getByIdReq);
        result.setData(sysUser.getId() != null ? sysUser : "");
        return result;
    }

    /**
    * 分页查询
    * @param input
    * @return
    */
    @GetMapping(value = "/list")
    public JSONResult getSysUserList(@Valid SysUserQueryInputDTO input) {
        JSONResult result = new JSONResult();
        SysUserOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(input, SysUserOuterClass.GetListReq.class);
        SysUserResponseDTO responseDTO = grpcSysUserClient.getSysUserList(getListReq);
        result.setData(responseDTO.getSysUsers());
        result.setTotalCount(responseDTO.getTotal());
        return result;
    }

//    /**
//    * 新增
//    * @param input
//    * @return
//    */
//    @PostMapping(value = "/add")
//    public JSONResult addSysUser(@Valid SysUserAddInputDTO input) {
//        JSONResult result = new JSONResult();
//        SysUserOuterClass.BaseSysUser baseSysUser = ProtoBufUtils.toProtoBuffer(input, SysUserOuterClass.BaseSysUser.class);
//        result.setData(grpcSysUserClient.addSysUser(baseSysUser));
//        return result;
//    }

    /**
    * 更新
    * @param input
    * @return
    */
    @PutMapping(value = "/update")
    public JSONResult updateSysUser(@Valid SysUserUpdateInputDTO input) {
        JSONResult result = new JSONResult();
        SysUserOuterClass.BaseSysUser baseSysUser = ProtoBufUtils.toProtoBuffer(input, SysUserOuterClass.BaseSysUser.class);
        result.setData(grpcSysUserClient.updateSysUser(baseSysUser));
        return result;
    }

    /**
    * 逻辑删除
    * @param input
    * @return
    */
    @PostMapping(value = "/delete")
    public JSONResult deleteSysUser(@Valid SysUserDeleteInputDTO input) {
        JSONResult result = new JSONResult();
        SysUserOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(input, SysUserOuterClass.ByIdReq.class);
        result.setData(grpcSysUserClient.deleteSysUser(req));
        return result;
    }

    /**
     * 新增员工,包含权限
     * @param input
     * @return
     */
    @PostMapping(value = "/add")
    @SneakyThrows
    public JSONResult addSysUser(@Valid SysUserAddInputDTO input) {
        JSONResult result = new JSONResult();
        SysUserOuterClass.BaseSysUser baseSysUser = ProtoBufUtils.toProtoBuffer(input, SysUserOuterClass.BaseSysUser.class);
        UpdateDBResponseDTO dto = grpcSysUserClient.addSysUser(baseSysUser);
        if(!dto.getSuccess()){
            throw new Exception(dto.getMessage());
        }
        result.setData(true);
        return result;
    }

    @GetMapping(value = "/userInfo")
    public JSONResult getUserMenus(RequestDTO input) {
        JSONResult result = new JSONResult();
        result.setData(SecurityBeanUtils.getUser());
        return result;
    }

}
