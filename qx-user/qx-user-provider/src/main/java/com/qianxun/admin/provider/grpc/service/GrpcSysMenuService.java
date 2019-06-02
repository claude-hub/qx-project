package com.qianxun.admin.provider.grpc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuQueryInputDTO;
import com.qianxun.admin.api.dto.sysMenu.response.SysMenuResponseDTO;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.admin.provider.service.SysMenuService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass;
import com.qianxun.grpc.lib.sysMenu.SysMenuServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

import java.util.List;

/**
 * @author Cloudy
 */
@GrpcService(SysMenuOuterClass.class)
@AllArgsConstructor
public class GrpcSysMenuService extends SysMenuServiceGrpc.SysMenuServiceImplBase {
    private final SysMenuService sysMenuService;
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();

    @Override
    public void getById(SysMenuOuterClass.ByIdReq request,
                        StreamObserver<SysMenuOuterClass.SysMenu> responseObserver) {
        SysMenu sysMenu = sysMenuService.getById(request.getId());
        SysMenuOuterClass.SysMenu res = ProtoBufUtils.toProtoBuffer(sysMenu, SysMenuOuterClass.SysMenu.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysMenuOuterClass.GetListReq request,
                        StreamObserver<SysMenuOuterClass.PageList> responseObserver) {
        SysMenuQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysMenuQueryInputDTO.class);
        IPage<SysMenu> page = new Page<SysMenu>(inputDTO.getPage(), inputDTO.getPageSize());
        IPage pageList;
        if (inputDTO.getQuery() == null || inputDTO.getQuery().equals("")) {
            pageList = sysMenuService.page(page);
        } else {
            pageList = sysMenuService.page(page, Wrappers.<SysMenu>query().lambda()
                    .and(item -> item
                            .like(SysMenu::getName, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getParentId, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getPermission, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getComponent, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getPath, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getIcon, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getSort, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getType, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getKeepAlive, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getCreatedAt, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getUpdatedAt, inputDTO.getQuery())
                            .or()
                            .like(SysMenu::getDeleted, inputDTO.getQuery())
                    )
            );
        }
        SysMenuResponseDTO dto = new SysMenuResponseDTO();
        dto.setTotal((int) pageList.getTotal());
        dto.setSysMenus(pageList.getRecords());
        SysMenuOuterClass.PageList res = ProtoBufUtils.toProtoBuffer(dto, SysMenuOuterClass.PageList.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void insert(SysMenuOuterClass.BaseSysMenu request,
                       StreamObserver<SysMenuOuterClass.Result> responseObserver) {
        SysMenu sysMenu = ProtoBufUtils.fromProtoBuffer(request, SysMenu.class);
        responseDTO.setSuccess(sysMenuService.save(sysMenu));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysMenuOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysMenuOuterClass.SysMenu request,
                       StreamObserver<SysMenuOuterClass.Result> responseObserver) {
        SysMenu sysMenu = ProtoBufUtils.fromProtoBuffer(request, SysMenu.class);
        responseDTO.setSuccess(sysMenuService.updateById(sysMenu));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysMenuOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysMenuOuterClass.ByIdReq request,
                       StreamObserver<SysMenuOuterClass.Result> responseObserver) {
        responseDTO.setSuccess(sysMenuService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysMenuOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    /**
     * 获取当前用户的菜单
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUserMenus(SysMenuOuterClass.ByIdReq request,
                             StreamObserver<SysMenuOuterClass.SysMenu> responseObserver) {
        List<SysMenu> menus = sysMenuService.getUserMenus(request.getId());
        for (SysMenu menuItem : menus) {
            responseObserver.onNext(ProtoBufUtils.toProtoBuffer(menuItem, SysMenuOuterClass.SysMenu.class));
        }
        responseObserver.onCompleted();
    }

    /**
     * 获取所有菜单列表
     * @param request
     * @param responseObserver
     */
    @Override
    public void getAllList(SysMenuOuterClass.GetListReq request,
                             StreamObserver<SysMenuOuterClass.SysMenu> responseObserver) {
        List<SysMenu> menus = sysMenuService.list();
        for (SysMenu menuItem : menus) {
            responseObserver.onNext(ProtoBufUtils.toProtoBuffer(menuItem, SysMenuOuterClass.SysMenu.class));
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getMenusByRoleId(SysMenuOuterClass.ByIdReq request,
                                 StreamObserver<SysMenuOuterClass.SysMenu> responseObserver) {
        List<SysMenu> menus = sysMenuService.getMenusByRoleId(request.getId());
        for (SysMenu menuItem : menus) {
            responseObserver.onNext(ProtoBufUtils.toProtoBuffer(menuItem, SysMenuOuterClass.SysMenu.class));
        }
        responseObserver.onCompleted();
    }
}
