package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.sysMenu.request.*;
import com.qianxun.admin.api.dto.sysMenu.response.SysMenuResponseDTO;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysMenuClient;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author Cloudy
 *  */
@RestController
@AllArgsConstructor
@RequestMapping("/api/sysMenu")
public class SysMenuController {
    private final GrpcSysMenuClient grpcSysMenuClient;

    /**
    * selectById
    * @param input
    * @return
    */
    @GetMapping(value = "/item")
    public JSONResult getSysMenuId(@Valid SysMenuSearchByIdDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.ByIdReq.class);
        SysMenuDTO sysMenuDTO = grpcSysMenuClient.getSysMenuById(getByIdReq);
        result.setData(sysMenuDTO.getId() != null ? sysMenuDTO : "");
        return result;
    }

    /**
    * 根据语言分页查询
    * @param input
    * @return
    */
    @GetMapping(value = "/list")
    @PreAuthorize("@qx.hasPermission('sys_menu_del')")
    public JSONResult getSysMenuList(@Valid SysMenuQueryInputDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.GetListReq.class);
        SysMenuResponseDTO responseDTO = grpcSysMenuClient.getSysMenuList(getListReq);
        result.setData(responseDTO.getSysMenus());
        result.setTotalCount(responseDTO.getTotal());
        return result;
    }

    /**
    * 根据语言新增
    * @param input
    * @return
    */
    @PostMapping(value = "/add")
    public JSONResult addSysMenu(@Valid SysMenuAddInputDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.BaseSysMenu baseSysMenu = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.BaseSysMenu.class);
        result.setData(grpcSysMenuClient.addSysMenu(baseSysMenu));
        return result;
    }

    /**
    * 更新
    * @param input
    * @return
    */
    @PutMapping(value = "/update")
    public JSONResult updateSysMenu(@Valid SysMenuUpdateInputDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.SysMenu sysMenu = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.SysMenu.class);
        result.setData(grpcSysMenuClient.updateSysMenu(sysMenu));
        return result;
    }

    /**
    * 逻辑删除
    * @param input
    * @return
    */
    @DeleteMapping(value = "/delete")
    public JSONResult deleteSysMenu(@Valid SysMenuDeleteInputDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.ByIdReq.class);
        result.setData(grpcSysMenuClient.deleteSysMenu(req));
        return result;
    }

    @GetMapping(value = "/userMenus")
    public JSONResult getUserMenus(@Valid SysMenuSearchByIdDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.ByIdReq.class);
        result.setData(grpcSysMenuClient.getUserMenus(getByIdReq));
        return result;
    }
}
