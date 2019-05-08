package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.admin.api.utils.SysLangUtils;
import com.qianxun.grpc.lib.sysLang.SysLangOuterClass;
import com.qianxun.grpc.lib.sysLang.SysLangServiceGrpc;
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
public class GrpcSysLangClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;


    public SysLang getLangById(int id) {
        SysLangServiceGrpc.SysLangServiceBlockingStub stub = SysLangServiceGrpc.newBlockingStub(serverChannel);
        SysLangOuterClass.SysLang res = stub.getById(SysLangOuterClass.GetByIdReq.newBuilder().setId(id).build());
        return SysLangUtils.grpcMessageToEntity(res);
    }

    public List<SysLang> getLangList() {
        SysLangServiceGrpc.SysLangServiceBlockingStub stub = SysLangServiceGrpc.newBlockingStub(serverChannel);
        Iterator<SysLangOuterClass.SysLang> sysLangIterator;
        List<SysLang> sysLangs = new ArrayList<>();
        try {
            sysLangIterator = stub.getList(SysLangOuterClass.GetListReq.newBuilder().build());
            for (int i = 1; sysLangIterator.hasNext(); i++) {
                SysLangOuterClass.SysLang sysLang = sysLangIterator.next();
                sysLangs.add(SysLangUtils.grpcMessageToEntity(sysLang));
            }
        }catch (StatusRuntimeException e) {
        }
        return sysLangs;
    }

    public boolean addLang(SysLang sysLang) {
        SysLangServiceGrpc.SysLangServiceBlockingStub stub = SysLangServiceGrpc.newBlockingStub(serverChannel);
        SysLangOuterClass.Result res = stub.insert(SysLangUtils.entityToGrpcMessage(sysLang));
        return res.getSuccess();
    }
}
