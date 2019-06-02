package com.qianxun.admin.provider.grpc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRolePermissionDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
import com.qianxun.admin.api.dto.sysRole.response.SysRoleResponseDTO;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.admin.provider.service.SysRoleService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysRole.SysRoleOuterClass;
import com.qianxun.grpc.lib.sysRole.SysRoleServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

/**
 * @author Cloudy
 *  */
@GrpcService(SysRoleOuterClass.class)
@AllArgsConstructor
public class GrpcSysRoleService extends SysRoleServiceGrpc.SysRoleServiceImplBase {
    private final SysRoleService sysRoleService;
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();

    @Override
    public void getById(SysRoleOuterClass.ByIdReq request,
                        StreamObserver<SysRoleOuterClass.SysRole> responseObserver) {
        SysRole sysRole = sysRoleService.getById(request.getId());
        SysRoleOuterClass.SysRole res = ProtoBufUtils.toProtoBuffer(sysRole, SysRoleOuterClass.SysRole.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysRoleOuterClass.GetListReq request,
                        StreamObserver<SysRoleOuterClass.PageList> responseObserver) {
        SysRoleQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysRoleQueryInputDTO.class);
        IPage<SysRole> page = new Page<SysRole>(inputDTO.getPage(),inputDTO.getPageSize());
        IPage pageList;
        if(inputDTO.getQuery() == null || inputDTO.getQuery().equals("")){
            pageList = sysRoleService.page(page);
        }else {
            pageList = sysRoleService.page(page, Wrappers.<SysRole>query().lambda()
                    .and(item -> item
                                                                                                                                                                                                     .like(SysRole::getName, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysRole::getRoleDesc, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysRole::getRoleCode, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysRole::getCreatedAt, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysRole::getUpdatedAt, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                            .like(SysRole::getDeleted, inputDTO.getQuery())
                                                                                                                    )

            );
        }
        SysRoleResponseDTO dto = new SysRoleResponseDTO();
        dto.setTotal((int) pageList.getTotal());
        dto.setSysRoles(pageList.getRecords());
        SysRoleOuterClass.PageList res = ProtoBufUtils.toProtoBuffer(dto, SysRoleOuterClass.PageList.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void insert(SysRoleOuterClass.BaseSysRole request,
                       StreamObserver<SysRoleOuterClass.Result> responseObserver) {
        SysRole sysRole = ProtoBufUtils.fromProtoBuffer(request, SysRole.class);
        responseDTO.setSuccess(sysRoleService.save(sysRole));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysRoleOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysRoleOuterClass.SysRole request,
                       StreamObserver<SysRoleOuterClass.Result> responseObserver) {
        SysRole sysRole = ProtoBufUtils.fromProtoBuffer(request, SysRole.class);
        responseDTO.setSuccess(sysRoleService.updateById(sysRole));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysRoleOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysRoleOuterClass.ByIdReq request,
                       StreamObserver<SysRoleOuterClass.Result> responseObserver) {
        responseDTO.setSuccess(sysRoleService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysRoleOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    public void addRolePerms(SysRoleOuterClass.RolePermsReq request,
                             StreamObserver<SysRoleOuterClass.Result> responseObserver) {
        SysRolePermissionDTO dto = ProtoBufUtils.fromProtoBuffer(request, SysRolePermissionDTO.class);
        UpdateDBResponseDTO updateDBResponseDTO = sysRoleService.addRolePerms(dto);
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(updateDBResponseDTO, SysRoleOuterClass.Result.class));
        responseObserver.onCompleted();

    }
}
