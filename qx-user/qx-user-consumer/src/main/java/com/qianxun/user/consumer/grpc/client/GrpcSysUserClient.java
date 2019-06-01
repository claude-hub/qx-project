package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysUser.response.SysUserResponseDTO;
import com.qianxun.admin.api.entity.SysUser;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysUser.SysUserOuterClass;
import com.qianxun.grpc.lib.sysUser.SysUserServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Cloudy
 *  */
@Service
public class GrpcSysUserClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysUser getSysUserById(SysUserOuterClass.ByIdReq getByIdReq) {
        SysUserServiceGrpc.SysUserServiceBlockingStub stub = SysUserServiceGrpc.newBlockingStub(serverChannel);
        SysUserOuterClass.SysUser res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysUser.class);
    }

    public SysUserResponseDTO getSysUserList(SysUserOuterClass.GetListReq getListReq) {
        SysUserServiceGrpc.SysUserServiceBlockingStub stub = SysUserServiceGrpc.newBlockingStub(serverChannel);
        SysUserOuterClass.PageList pageList = stub.getList(getListReq);
        return ProtoBufUtils.fromProtoBuffer(pageList, SysUserResponseDTO.class);
    }

    public UpdateDBResponseDTO addSysUser(SysUserOuterClass.BaseSysUser baseSysUser) {
        SysUserServiceGrpc.SysUserServiceBlockingStub stub = SysUserServiceGrpc.newBlockingStub(serverChannel);
        SysUserOuterClass.Result res = stub.insert(baseSysUser);
        return ProtoBufUtils.fromProtoBuffer(res, UpdateDBResponseDTO.class);
    }

    public Boolean updateSysUser(SysUserOuterClass.SysUser role) {
        SysUserServiceGrpc.SysUserServiceBlockingStub stub = SysUserServiceGrpc.newBlockingStub(serverChannel);
        SysUserOuterClass.Result res = stub.update(role);
        return res.getSuccess();
    }

    public Boolean deleteSysUser(SysUserOuterClass.ByIdReq req) {
        SysUserServiceGrpc.SysUserServiceBlockingStub stub = SysUserServiceGrpc.newBlockingStub(serverChannel);
        SysUserOuterClass.Result res = stub.delete(req);
        return res.getSuccess();
    }
}
