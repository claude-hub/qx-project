package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.base.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.sysMenu.request.*;
import com.qianxun.admin.api.dto.sysMenu.response.SysMenuResponseDTO;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysMenuClient;
import lombok.AllArgsConstructor;
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
    @GetMapping(value = "/{id}")
    public JSONResult getSysMenuId(@Valid SearchByIdInputDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.ByIdReq.class);
        SysMenu sysMenu = grpcSysMenuClient.getSysMenuById(getByIdReq);
        result.setData(sysMenu.getId() != null ? sysMenu : "");
        return result;
    }

    /**
    * 根据语言分页查询
    * @param input
    * @return
    */
    @GetMapping(value = "/list")
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
    @DeleteMapping(value = "/{id}")
    public JSONResult deleteSysMenu(@Valid SysMenuDeleteInputDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.ByIdReq.class);
        result.setData(grpcSysMenuClient.deleteSysMenu(req));
        return result;
    }
}
