package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.authUser.AuthUserOuterClass;
import com.qianxun.grpc.lib.authUser.AuthUserServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Cloudy
 * Date: 2019/5/26 3:20
 */
@Service
public class GrpcAuthUserClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysUserDTO getSysUserByAccount(String username) {
        AuthUserServiceGrpc.AuthUserServiceBlockingStub stub =AuthUserServiceGrpc.newBlockingStub(serverChannel);
        AuthUserOuterClass.ByAccountReq req = AuthUserOuterClass.ByAccountReq.newBuilder().setAccount(username).build();
        AuthUserOuterClass.AuthUser authUser = stub.getByAccount(req);
        return ProtoBufUtils.fromProtoBuffer(authUser, SysUserDTO.class);
    }

    public SysUserDTO signIn(AuthUserOuterClass.SignInReq req){
        AuthUserServiceGrpc.AuthUserServiceBlockingStub stub =AuthUserServiceGrpc.newBlockingStub(serverChannel);
        AuthUserOuterClass.AuthUser authUser = stub.signIn(req);
        return ProtoBufUtils.fromProtoBuffer(authUser, SysUserDTO.class);
    }

    public SysUserDTO signIn(AuthUserOuterClass.SignInByTokenReq req){
        AuthUserServiceGrpc.AuthUserServiceBlockingStub stub =AuthUserServiceGrpc.newBlockingStub(serverChannel);
        AuthUserOuterClass.AuthUser authUser = stub.signInByToken(req);
        return ProtoBufUtils.fromProtoBuffer(authUser, SysUserDTO.class);
    }
}
