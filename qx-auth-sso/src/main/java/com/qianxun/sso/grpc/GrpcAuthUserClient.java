package com.qianxun.sso.grpc;

import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.authUser.AuthUserOuterClass;
import com.qianxun.grpc.lib.authUser.AuthUserServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Cloudy
 * Date: 2019/5/17 12:48
 */
@Service
public class GrpcAuthUserClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysUserDTO getSysUserByAccount(AuthUserOuterClass.ByAccountReq req) {
        AuthUserServiceGrpc.AuthUserServiceBlockingStub stub =AuthUserServiceGrpc.newBlockingStub(serverChannel);
        AuthUserOuterClass.AuthUser authUser = stub.getByAccount(req);
        return ProtoBufUtils.fromProtoBuffer(authUser, SysUserDTO.class);
    }
}
