package com.qianxun.admin.provider.grpc.service.sysLang;

/**
 * @author Cloudy
 * Date: 2019/5/7 21:58
 */

import com.qianxun.admin.api.dto.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysLang.request.SysLangQueryInputDTO;
import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.admin.provider.service.SysLangService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
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
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();

    @Override
    public void getById(SysLangOuterClass.ByIdReq request,
                        StreamObserver<SysLangOuterClass.SysLang> responseObserver) {
        SysLang sysLang = sysLangService.getById(request.getId());
        SysLangOuterClass.SysLang res = ProtoBufUtils.toProtoBuffer(sysLang, SysLangOuterClass.SysLang.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysLangOuterClass.GetListReq request,
                        StreamObserver<SysLangOuterClass.SysLang> responseObserver) {
        SysLangQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysLangQueryInputDTO.class);
        List<SysLang> sysLangList = sysLangService.list();
        for (SysLang sysLang : sysLangList) {
            responseObserver.onNext(ProtoBufUtils.toProtoBuffer(sysLang, SysLangOuterClass.SysLang.class));
        }
        responseObserver.onCompleted();
    }

    @Override
    public void insert(SysLangOuterClass.SysLang request,
                       StreamObserver<SysLangOuterClass.Result> responseObserver) {
        SysLang sysLang = ProtoBufUtils.fromProtoBuffer(request, SysLang.class);
        responseDTO.setSuccess(sysLangService.save(sysLang));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysLangOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysLangOuterClass.SysLang request,
                       StreamObserver<SysLangOuterClass.Result> responseObserver) {
        SysLang sysLang = ProtoBufUtils.fromProtoBuffer(request, SysLang.class);
        responseDTO.setSuccess(sysLangService.updateById(sysLang));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysLangOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysLangOuterClass.ByIdReq request,
                       StreamObserver<SysLangOuterClass.Result> responseObserver) {
        responseDTO.setSuccess(sysLangService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysLangOuterClass.Result.class));
        responseObserver.onCompleted();
    }
}
