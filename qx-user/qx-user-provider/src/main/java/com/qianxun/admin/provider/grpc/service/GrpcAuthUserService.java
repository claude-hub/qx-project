package com.qianxun.admin.provider.grpc.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qianxun.admin.api.dto.authUser.AuthUserInputDTO;
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
    @Override
    public void getByAccount(AuthUserOuterClass.ByAccountReq request,
                             StreamObserver<AuthUserOuterClass.AuthUser> responseObserver) {

        AuthUserInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, AuthUserInputDTO.class);
//        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>query().lambda()
//                .eq(SysUser::getPhone, inputDTO.getAccount())
//                .or()
//                .eq(SysUser::getUserName, inputDTO.getAccount())
//                .or()
//                .eq(SysUser::getEmail, inputDTO.getAccount())
//        );

        SysUserDTO sysUserDTO = sysUserService.getUserInfoByAccount(inputDTO.getAccount());
        AuthUserResponseDTO responseDTO = new AuthUserResponseDTO();
        BeanUtils.copyProperties(sysUserDTO, responseDTO);
        AuthUserOuterClass.AuthUser res = ProtoBufUtils.toProtoBuffer(responseDTO, AuthUserOuterClass.AuthUser.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
