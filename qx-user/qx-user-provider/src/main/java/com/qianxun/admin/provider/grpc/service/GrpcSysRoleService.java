package com.qianxun.admin.provider.grpc.service;

/**
 * @author Cloudy
 * Date: 2019/5/7 21:58
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleSearchByIdDTO;
import com.qianxun.admin.api.dto.sysRole.response.SysRoleResponseDTO;
import com.qianxun.admin.provider.service.SysRoleService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysRole.SysRoleOuterClass;
import com.qianxun.grpc.lib.sysRole.SysRoleServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;


@GrpcService(SysRoleOuterClass.class)
@AllArgsConstructor
public class GrpcSysRoleService extends SysRoleServiceGrpc.SysRoleServiceImplBase {
    private final SysRoleService sysRoleService;
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();

    @Override
    public void getById(SysRoleOuterClass.ByIdReq request,
                        StreamObserver<SysRoleOuterClass.SysRole> responseObserver) {
        SysRoleSearchByIdDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysRoleSearchByIdDTO.class);
        SysRoleDTO sysRoleDTO = sysRoleService.searchById(inputDTO);
        SysRoleOuterClass.SysRole res = ProtoBufUtils.toProtoBuffer(sysRoleDTO, SysRoleOuterClass.SysRole.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysRoleOuterClass.GetListReq request,
                        StreamObserver<SysRoleOuterClass.PageList> responseObserver) {
        SysRoleQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysRoleQueryInputDTO.class);
        Page page = new Page(inputDTO.getPage(),inputDTO.getPageSize());
        IPage pageList = sysRoleService.getRoles(page, inputDTO);
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
        SysRoleDTO sysRoleDTO = ProtoBufUtils.fromProtoBuffer(request, SysRoleDTO.class);
        responseDTO.setSuccess(sysRoleService.saveRole(sysRoleDTO));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysRoleOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysRoleOuterClass.SysRole request,
                       StreamObserver<SysRoleOuterClass.Result> responseObserver) {
        SysRoleDTO sysRoleDTO = ProtoBufUtils.fromProtoBuffer(request, SysRoleDTO.class);
        responseDTO.setSuccess(sysRoleService.updateRole(sysRoleDTO));
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
}