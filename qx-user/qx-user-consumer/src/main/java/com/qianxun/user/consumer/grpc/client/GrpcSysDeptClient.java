package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.sysDept.response.SysDeptResponseDTO;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysDept.SysDeptOuterClass;
import com.qianxun.grpc.lib.sysDept.SysDeptServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Cloudy
 * Date: 2019-05-13 00:37:19
 */
@Service
public class GrpcSysDeptClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysDept getSysDeptById(SysDeptOuterClass.ByIdReq getByIdReq) {
        SysDeptServiceGrpc.SysDeptServiceBlockingStub stub = SysDeptServiceGrpc.newBlockingStub(serverChannel);
        SysDeptOuterClass.SysDept res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysDept.class);
    }

    public SysDeptResponseDTO getSysDeptList(SysDeptOuterClass.GetListReq getListReq) {
        SysDeptServiceGrpc.SysDeptServiceBlockingStub stub = SysDeptServiceGrpc.newBlockingStub(serverChannel);
        SysDeptOuterClass.PageList pageList = stub.getList(getListReq);
        return ProtoBufUtils.fromProtoBuffer(pageList, SysDeptResponseDTO.class);
    }

    public Boolean addSysDept(SysDeptOuterClass.BaseSysDept baseSysDept) {
        SysDeptServiceGrpc.SysDeptServiceBlockingStub stub = SysDeptServiceGrpc.newBlockingStub(serverChannel);
        SysDeptOuterClass.Result res = stub.insert(baseSysDept);
        return res.getSuccess();
    }

    public Boolean updateSysDept(SysDeptOuterClass.SysDept role) {
        SysDeptServiceGrpc.SysDeptServiceBlockingStub stub = SysDeptServiceGrpc.newBlockingStub(serverChannel);
        SysDeptOuterClass.Result res = stub.update(role);
        return res.getSuccess();
    }

    public Boolean deleteSysDept(SysDeptOuterClass.ByIdReq req) {
        SysDeptServiceGrpc.SysDeptServiceBlockingStub stub = SysDeptServiceGrpc.newBlockingStub(serverChannel);
        SysDeptOuterClass.Result res = stub.delete(req);
        return res.getSuccess();
    }
}
