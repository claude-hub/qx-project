package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.sysDept.response.SysDeptResponseDTO;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysDept.SysDeptOuterClass;
import com.qianxun.grpc.lib.sysDept.SysDeptServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Cloudy
 *  */
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

    public List<SysDept> getAllMenus() {
        SysDeptServiceGrpc.SysDeptServiceBlockingStub stub = SysDeptServiceGrpc.newBlockingStub(serverChannel);
        Iterator<SysDeptOuterClass.SysDept> iterator;
        List<SysDept> menus = new ArrayList<>();
        iterator = stub.getAllList(null);
        while (iterator.hasNext()) {
            SysDeptOuterClass.SysDept sysDept = iterator.next();
            menus.add(ProtoBufUtils.fromProtoBuffer(sysDept, SysDept.class));
        }
        return menus;
    }
}
