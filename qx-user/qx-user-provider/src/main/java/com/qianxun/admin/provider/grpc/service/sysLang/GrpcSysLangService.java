package com.qianxun.admin.provider.grpc.service.sysLang;

/**
 * @author Cloudy
 * Date: 2019/5/7 21:58
 */

import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.admin.api.utils.SysLangUtils;
import com.qianxun.admin.provider.service.SysLangService;
import com.qianxun.grpc.lib.sysLang.SysLangOuterClass;
import com.qianxun.grpc.lib.sysLang.SysLangServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import java.util.List;

@GrpcService(SysLangOuterClass.class)
@AllArgsConstructor
public class GrpcSysLangService extends SysLangServiceGrpc.SysLangServiceImplBase {
    private final SysLangService sysLangService;

    @Override
    public void getById(SysLangOuterClass.GetByIdReq request,
                        StreamObserver<SysLangOuterClass.SysLang> responseObserver){
        SysLang sysLang = sysLangService.getSysLang(request.getId());
        responseObserver.onNext(SysLangUtils.entityToGrpcMessage(sysLang));
        responseObserver.onCompleted();
    }
    @Override
    public void getList(SysLangOuterClass.GetListReq request,
                        StreamObserver<SysLangOuterClass.SysLang> responseObserver){
       List<SysLang> sysLangList = sysLangService.findAllSysLangs();
        for (SysLang sysLang: sysLangList) {
            responseObserver.onNext(SysLangUtils.entityToGrpcMessage(sysLang));
        }
        responseObserver.onCompleted();
    }
    @Override
    public void insert(SysLangOuterClass.SysLang request,
                       StreamObserver<SysLangOuterClass.Result> responseObserver) {

    }
//    private SysLang grpcMessageToEntity(SysLangOuterClass.SysLang res){
//        SysLang sysLang = new SysLang();
//        sysLang.setId(res.getId());
//        sysLang.setName(res.getName());
//        sysLang.setCreatedAt(new Date(res.getCreatedAt().getSeconds()*1000));
//        sysLang.setUpdatedAt(new Date(res.getUpdatedAt().getSeconds()*1000));
//        sysLang.setStatus(res.getStatus());
//        sysLang.setDbSource(res.getDbSource());
//        return sysLang;
//    }
//    private SysLangOuterClass.SysLang entityToGrpcMessage(SysLang sysLang){
//        return SysLangOuterClass.SysLang
//                .newBuilder()
//                .setId(sysLang.getId())
//                .setName(sysLang.getName())
//                .setCreatedAt(Timestamps.fromMillis(sysLang.getCreatedAt().getTime()))
//                .setUpdatedAt(Timestamps.fromMillis(sysLang.getUpdatedAt().getTime()))
//                .setDbSource(sysLang.getDbSource())
//                .build();
//    }

//    /**
//     */
//    public void getById(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetByIdReq request,
//                        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> responseObserver) {
//        asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
//    }
//
//    /**
//     */
//    public void getList(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq request,
//                        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> responseObserver) {
//        asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
//    }
//
//    /**
//     */
//    public void insert(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request,
//                       io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
//        asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
//    }
//
//    /**
//     */
//    public void update(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request,
//                       io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
//        asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
//    }
//
//    /**
//     */
//    public void delete(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request,
//                       io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
//        asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
//    }
}
