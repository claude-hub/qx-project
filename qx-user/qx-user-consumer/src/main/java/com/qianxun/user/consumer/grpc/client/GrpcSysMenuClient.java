package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.sysMenu.response.SysMenuResponseDTO;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass;
import com.qianxun.grpc.lib.sysMenu.SysMenuServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Cloudy
 * Date 2019-05-13 21:52:31
 */
@Service
public class GrpcSysMenuClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysMenuDTO getSysMenuById(SysMenuOuterClass.ByIdReq getByIdReq) {
        SysMenuServiceGrpc.SysMenuServiceBlockingStub stub = SysMenuServiceGrpc.newBlockingStub(serverChannel);
        SysMenuOuterClass.SysMenu res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysMenuDTO.class);
    }

    public SysMenuResponseDTO getSysMenuList(SysMenuOuterClass.GetListReq getListReq) {
        SysMenuServiceGrpc.SysMenuServiceBlockingStub stub = SysMenuServiceGrpc.newBlockingStub(serverChannel);
        SysMenuOuterClass.PageList pageList = stub.getList(getListReq);
        return ProtoBufUtils.fromProtoBuffer(pageList, SysMenuResponseDTO.class);
    }

    public Boolean addSysMenu(SysMenuOuterClass.BaseSysMenu baseSysMenu) {
        SysMenuServiceGrpc.SysMenuServiceBlockingStub stub = SysMenuServiceGrpc.newBlockingStub(serverChannel);
        SysMenuOuterClass.Result res = stub.insert(baseSysMenu);
        return res.getSuccess();
    }

    public Boolean updateSysMenu(SysMenuOuterClass.SysMenu role) {
        SysMenuServiceGrpc.SysMenuServiceBlockingStub stub = SysMenuServiceGrpc.newBlockingStub(serverChannel);
        SysMenuOuterClass.Result res = stub.update(role);
        return res.getSuccess();
    }

    public Boolean deleteSysMenu(SysMenuOuterClass.ByIdReq req) {
        SysMenuServiceGrpc.SysMenuServiceBlockingStub stub = SysMenuServiceGrpc.newBlockingStub(serverChannel);
        SysMenuOuterClass.Result res = stub.delete(req);
        return res.getSuccess();
    }
}
