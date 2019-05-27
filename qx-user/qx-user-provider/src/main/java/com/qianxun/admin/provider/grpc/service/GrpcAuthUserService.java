package com.qianxun.admin.provider.grpc.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qianxun.admin.api.dto.authUser.AuthUserInputDTO;
import com.qianxun.admin.api.dto.authUser.AuthUserLoginInputDTO;
import com.qianxun.admin.api.dto.authUser.AuthUserResponseDTO;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.entity.SysUser;
import com.qianxun.admin.provider.service.SysUserService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.authUser.AuthUserOuterClass;
import com.qianxun.grpc.lib.authUser.AuthUserServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.BeanUtils;

/**
 * @author Cloudy
 * Date: 2019/5/17 14:12
 */
@GrpcService(AuthUserOuterClass.class)
@AllArgsConstructor
public class GrpcAuthUserService extends AuthUserServiceGrpc.AuthUserServiceImplBase {
    private final SysUserService sysUserService;

    /**
     * 单点登录接口
     * @param request
     * @param responseObserver
     */
    @Override
    public void getByAccount(AuthUserOuterClass.ByAccountReq request,
                             StreamObserver<AuthUserOuterClass.AuthUser> responseObserver) {

        AuthUserInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, AuthUserInputDTO.class);
        SysUserDTO sysUserDTO = sysUserService.getUserInfoByAccount(inputDTO.getAccount());
        AuthUserResponseDTO responseDTO = new AuthUserResponseDTO();
        BeanUtils.copyProperties(sysUserDTO, responseDTO);
        AuthUserOuterClass.AuthUser res = ProtoBufUtils.toProtoBuffer(responseDTO, AuthUserOuterClass.AuthUser.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    /**
     * jwt登录
     * @param request
     * @param responseObserver
     */
    @Override
    public void signIn(AuthUserOuterClass.SignInReq request,
                       StreamObserver<AuthUserOuterClass.AuthUser> responseObserver) {
        AuthUserLoginInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, AuthUserLoginInputDTO.class);
        SysUserDTO sysUserDTO = sysUserService.signIn(inputDTO.getLoginStr(),inputDTO.getPassword());
        AuthUserOuterClass.AuthUser res = ProtoBufUtils.toProtoBuffer(sysUserDTO, AuthUserOuterClass.AuthUser.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void signInByToken(AuthUserOuterClass.SignInByTokenReq request,
                              StreamObserver<AuthUserOuterClass.AuthUser> responseObserver) {
        SysUserDTO sysUserDTO = sysUserService.signIn(request.getToken());
        AuthUserOuterClass.AuthUser res = ProtoBufUtils.toProtoBuffer(sysUserDTO, AuthUserOuterClass.AuthUser.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
