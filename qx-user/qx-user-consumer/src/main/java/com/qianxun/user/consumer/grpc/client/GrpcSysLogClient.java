package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.sysLog.response.SysLogResponseDTO;
import com.qianxun.admin.api.entity.SysLog;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysLog.SysLogOuterClass;
import com.qianxun.grpc.lib.sysLog.SysLogServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Cloudy
 *  */
@Service
public class GrpcSysLogClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysLog getSysLogById(SysLogOuterClass.ByIdReq getByIdReq) {
        SysLogServiceGrpc.SysLogServiceBlockingStub stub = SysLogServiceGrpc.newBlockingStub(serverChannel);
        SysLogOuterClass.SysLog res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysLog.class);
    }

    public SysLogResponseDTO getSysLogList(SysLogOuterClass.GetListReq getListReq) {
        SysLogServiceGrpc.SysLogServiceBlockingStub stub = SysLogServiceGrpc.newBlockingStub(serverChannel);
        SysLogOuterClass.PageList pageList = stub.getList(getListReq);
        return ProtoBufUtils.fromProtoBuffer(pageList, SysLogResponseDTO.class);
    }

    public Boolean addSysLog(SysLogOuterClass.BaseSysLog baseSysLog) {
        SysLogServiceGrpc.SysLogServiceBlockingStub stub = SysLogServiceGrpc.newBlockingStub(serverChannel);
        SysLogOuterClass.Result res = stub.insert(baseSysLog);
        return res.getSuccess();
    }

    public Boolean updateSysLog(SysLogOuterClass.SysLog role) {
        SysLogServiceGrpc.SysLogServiceBlockingStub stub = SysLogServiceGrpc.newBlockingStub(serverChannel);
        SysLogOuterClass.Result res = stub.update(role);
        return res.getSuccess();
    }

    public Boolean deleteSysLog(SysLogOuterClass.ByIdReq req) {
        SysLogServiceGrpc.SysLogServiceBlockingStub stub = SysLogServiceGrpc.newBlockingStub(serverChannel);
        SysLogOuterClass.Result res = stub.delete(req);
        return res.getSuccess();
    }
}
