package com.qianxun.admin.provider.grpc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserQueryInputDTO;
import com.qianxun.admin.api.dto.sysUser.response.SysUserResponseDTO;
import com.qianxun.admin.api.entity.SysUser;
import com.qianxun.admin.provider.service.SysUserService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysUser.SysUserOuterClass;
import com.qianxun.grpc.lib.sysUser.SysUserServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

/**
 * @author Cloudy
 *  */
@GrpcService(SysUserOuterClass.class)
@AllArgsConstructor
public class GrpcSysUserService extends SysUserServiceGrpc.SysUserServiceImplBase {
    private final SysUserService sysUserService;
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();

    @Override
    public void getById(SysUserOuterClass.ByIdReq request,
                        StreamObserver<SysUserOuterClass.SysUser> responseObserver) {
        SysUser sysUser = sysUserService.getById(request.getId());
        SysUserOuterClass.SysUser res = ProtoBufUtils.toProtoBuffer(sysUser, SysUserOuterClass.SysUser.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysUserOuterClass.GetListReq request,
                        StreamObserver<SysUserOuterClass.PageList> responseObserver) {
        SysUserQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysUserQueryInputDTO.class);
        IPage<SysUser> page = new Page<SysUser>(inputDTO.getPage(),inputDTO.getPageSize());
        IPage pageList;
        if(inputDTO.getQuery() == null || inputDTO.getQuery().equals("")){
            pageList = sysUserService.page(page);
        }else {
            pageList = sysUserService.page(page, Wrappers.<SysUser>query().lambda()
                    .and(item -> item
                                                                                                                                                                                                     .like(SysUser::getDeptId, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getName, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getIdentification, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getPhone, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getEmail, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getAvatar, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getLocked, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getDeleted, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getUserName, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getResetPasswordToken, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getPasswordEncrypted, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getCreatedAt, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getUpdatedAt, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getCurrentToken, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getCurrentSignInAt, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysUser::getLastSignInAt, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                            .like(SysUser::getSignInCount, inputDTO.getQuery())
                                                                                                                    )

            );
        }
        SysUserResponseDTO dto = new SysUserResponseDTO();
        dto.setTotal((int) pageList.getTotal());
        dto.setSysUsers(pageList.getRecords());
        SysUserOuterClass.PageList res = ProtoBufUtils.toProtoBuffer(dto, SysUserOuterClass.PageList.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void insert(SysUserOuterClass.BaseSysUser request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        SysUser sysUser = ProtoBufUtils.fromProtoBuffer(request, SysUser.class);
        responseDTO.setSuccess(sysUserService.save(sysUser));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysUserOuterClass.SysUser request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        SysUser sysUser = ProtoBufUtils.fromProtoBuffer(request, SysUser.class);
        responseDTO.setSuccess(sysUserService.updateById(sysUser));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysUserOuterClass.ByIdReq request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        responseDTO.setSuccess(sysUserService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }
}
