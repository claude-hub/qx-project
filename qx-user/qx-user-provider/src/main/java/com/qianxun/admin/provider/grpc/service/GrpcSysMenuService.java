package com.qianxun.admin.provider.grpc.service;

/**
 * @author Cloudy
 * Date: 2019-05-13 14:37:45
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
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

/**
 * @author Cloudy
 * Date 2019-05-13 14:37:45
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
        Page page = new Page(inputDTO.getPage(),inputDTO.getPageSize());
        IPage pageList = sysMenuService.getSysMenus(page, inputDTO);
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
        SysMenuDTO sysMenuDTO = ProtoBufUtils.fromProtoBuffer(request, SysMenuDTO.class);
        responseDTO.setSuccess(sysMenuService.saveSysMenu(sysMenuDTO));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysMenuOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysMenuOuterClass.SysMenu request,
                       StreamObserver<SysMenuOuterClass.Result> responseObserver) {
        SysMenuDTO sysMenuDTO = ProtoBufUtils.fromProtoBuffer(request, SysMenuDTO.class);
        responseDTO.setSuccess(sysMenuService.updateSysMenu(sysMenuDTO));
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
}
