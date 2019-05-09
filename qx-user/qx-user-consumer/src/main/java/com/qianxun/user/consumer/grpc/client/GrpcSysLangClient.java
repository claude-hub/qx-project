package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.admin.api.utils.ProtoBufUtils;
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

    public SysLang getLangById(SysLangOuterClass.ByIdReq getByIdReq) {
        SysLangServiceGrpc.SysLangServiceBlockingStub stub = SysLangServiceGrpc.newBlockingStub(serverChannel);
        SysLangOuterClass.SysLang res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysLang.class);
    }

    public List<SysLang> getLangList(SysLangOuterClass.GetListReq getListReq) {
        SysLangServiceGrpc.SysLangServiceBlockingStub stub = SysLangServiceGrpc.newBlockingStub(serverChannel);
        Iterator<SysLangOuterClass.SysLang> sysLangIterator;
        List<SysLang> sysLangList = new ArrayList<>();
        try {
            sysLangIterator = stub.getList(getListReq);
            for (int i = 1; sysLangIterator.hasNext(); i++) {
                SysLangOuterClass.SysLang sysLang = sysLangIterator.next();
                sysLangList.add(ProtoBufUtils.fromProtoBuffer(sysLang, SysLang.class));
            }
        }catch (StatusRuntimeException e) {
        }
        return sysLangList;
    }

    public int addLang(SysLangOuterClass.SysLang lang) {
        SysLangServiceGrpc.SysLangServiceBlockingStub stub = SysLangServiceGrpc.newBlockingStub(serverChannel);
        SysLangOuterClass.Result res = stub.insert(lang);
        return res.getResult();
    }

    public int updateLang(SysLangOuterClass.SysLang lang) {
        SysLangServiceGrpc.SysLangServiceBlockingStub stub = SysLangServiceGrpc.newBlockingStub(serverChannel);
        SysLangOuterClass.Result res = stub.update(lang);
        return res.getResult();
    }

    public int deleteLang(SysLangOuterClass.ByIdReq req) {
        SysLangServiceGrpc.SysLangServiceBlockingStub stub = SysLangServiceGrpc.newBlockingStub(serverChannel);
        SysLangOuterClass.Result res = stub.delete(req);
        return res.getResult();
    }
}
