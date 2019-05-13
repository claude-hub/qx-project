package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.sysMenu.response.SysMenuResponseDTO;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass;
import com.qianxun.grpc.lib.sysMenu.SysMenuServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author cloudy
 * Date 2019-05-13 14:37:45
 */
@Service
public class GrpcSysMenuClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysMenu getSysMenuById(SysMenuOuterClass.ByIdReq getByIdReq) {
        SysMenuServiceGrpc.SysMenuServiceBlockingStub stub = SysMenuServiceGrpc.newBlockingStub(serverChannel);
        SysMenuOuterClass.SysMenu res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysMenu.class);
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
