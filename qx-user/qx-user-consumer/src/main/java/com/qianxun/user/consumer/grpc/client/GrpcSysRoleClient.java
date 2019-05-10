package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.sysRole.response.SysRoleResponseDTO;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.admin.api.utils.ProtoBufUtils;
import com.qianxun.grpc.lib.sysRole.SysRoleOuterClass;
import com.qianxun.grpc.lib.sysRole.SysRoleServiceGrpc;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/5/7 22:14
 */
@Service
public class GrpcSysRoleClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysRole getRoleById(SysRoleOuterClass.ByIdReq getByIdReq) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.SysRole res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysRole.class);
    }

    public SysRoleResponseDTO getRoleList(SysRoleOuterClass.GetListReq getListReq) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.PageList pageList = stub.getList(getListReq);
        return ProtoBufUtils.fromProtoBuffer(pageList, SysRoleResponseDTO.class);
    }

    public Boolean addRole(SysRoleOuterClass.SysRole Role) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.Result res = stub.insert(Role);
        return res.getSuccess();
    }

    public Boolean updateRole(SysRoleOuterClass.SysRole Role) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.Result res = stub.update(Role);
        return res.getSuccess();
    }

    public Boolean deleteRole(SysRoleOuterClass.ByIdReq req) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.Result res = stub.delete(req);
        return res.getSuccess();
    }
}
