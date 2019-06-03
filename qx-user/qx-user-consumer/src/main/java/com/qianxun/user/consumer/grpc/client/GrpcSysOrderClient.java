package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.sysOrder.response.SysOrderResponseDTO;
import com.qianxun.admin.api.entity.SysOrder;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass;
import com.qianxun.grpc.lib.sysOrder.SysOrderServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Cloudy
 *  */
@Service
public class GrpcSysOrderClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysOrder getSysOrderById(SysOrderOuterClass.ByIdReq getByIdReq) {
        SysOrderServiceGrpc.SysOrderServiceBlockingStub stub = SysOrderServiceGrpc.newBlockingStub(serverChannel);
        SysOrderOuterClass.SysOrder res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysOrder.class);
    }

    public SysOrderResponseDTO getSysOrderList(SysOrderOuterClass.GetListReq getListReq) {
        SysOrderServiceGrpc.SysOrderServiceBlockingStub stub = SysOrderServiceGrpc.newBlockingStub(serverChannel);
        SysOrderOuterClass.PageList pageList = stub.getList(getListReq);
        return ProtoBufUtils.fromProtoBuffer(pageList, SysOrderResponseDTO.class);
    }

    public Boolean addSysOrder(SysOrderOuterClass.BaseSysOrder baseSysOrder) {
        SysOrderServiceGrpc.SysOrderServiceBlockingStub stub = SysOrderServiceGrpc.newBlockingStub(serverChannel);
        SysOrderOuterClass.Result res = stub.insert(baseSysOrder);
        return res.getSuccess();
    }

    public Boolean updateSysOrder(SysOrderOuterClass.SysOrder role) {
        SysOrderServiceGrpc.SysOrderServiceBlockingStub stub = SysOrderServiceGrpc.newBlockingStub(serverChannel);
        SysOrderOuterClass.Result res = stub.update(role);
        return res.getSuccess();
    }

    public Boolean deleteSysOrder(SysOrderOuterClass.ByIdReq req) {
        SysOrderServiceGrpc.SysOrderServiceBlockingStub stub = SysOrderServiceGrpc.newBlockingStub(serverChannel);
        SysOrderOuterClass.Result res = stub.delete(req);
        return res.getSuccess();
    }
}
