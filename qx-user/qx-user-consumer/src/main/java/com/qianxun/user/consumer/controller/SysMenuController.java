package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.base.RequestDTO;
import com.qianxun.admin.api.dto.base.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.dto.sysMenu.request.*;
import com.qianxun.admin.api.dto.sysMenu.response.SysMenuResponseDTO;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.common.utils.mapper.BeanMapper;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysMenuClient;
import com.qianxun.user.consumer.utils.SecurityBeanUtils;
import com.qianxun.user.consumer.utils.TreeUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Cloudy
 *  */
@RestController
@AllArgsConstructor
@RequestMapping("/sysMenu")
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
    * 根据分页查询
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
    @PostMapping(value = "/delete")
    public JSONResult deleteSysMenu(@Valid SysMenuDeleteInputDTO input) {
        JSONResult result = new JSONResult();
        SysMenuOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(input, SysMenuOuterClass.ByIdReq.class);
        result.setData(grpcSysMenuClient.deleteSysMenu(req));
        return result;
    }

    /**
     * 获取当前用户的菜单
     * @return
     */
    @GetMapping(value = "/userMenus")
    public JSONResult getUserMenus(RequestDTO input) {
        JSONResult result = new JSONResult();
        SysUserDTO sysUserDTO = SecurityBeanUtils.getUser();
        if(sysUserDTO == null){
            result.setErrCode("403");
            result.setMessage("无权访问");
            return result;
        }
        List<SysMenu> menuList = grpcSysMenuClient.getUserMenus(sysUserDTO.getId());
        List<SysMenuDTO> sysMenus= BeanMapper.mapList(menuList, SysMenuDTO.class);
        result.setData(TreeUtil.buildByLoop(sysMenus, -1));
        return result;
    }

    /**
     * 获取树形菜单
     * @return
     */
    @GetMapping(value = "/tree")
    public JSONResult getMenuTree() {
        JSONResult result = new JSONResult();
        List<SysMenu> menuList = grpcSysMenuClient.getAllMenus();
        List<SysMenuDTO> sysMenus= BeanMapper.mapList(menuList, SysMenuDTO.class);
        result.setData(TreeUtil.buildByLoop(sysMenus, -1));
        return result;
    }

    /**
     * 角色的菜单
     * @param inputDTO
     * @return
     */
    @GetMapping(value = "/roleMenus")
    public JSONResult getMenusByRoleId(@Valid SearchByIdInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        List<SysMenu> menuList = grpcSysMenuClient.getMenusByRoleId(inputDTO.getId());
//        List<SysMenuDTO> sysMenus= BeanMapper.mapList(menuList, SysMenuDTO.class);
//        result.setData(TreeUtil.buildByLoop(sysMenus, -1));
        result.setData(menuList);
        return result;
    }
}
