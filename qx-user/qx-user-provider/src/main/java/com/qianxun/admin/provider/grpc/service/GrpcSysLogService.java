package com.qianxun.admin.provider.grpc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysLog.request.SysLogQueryInputDTO;
import com.qianxun.admin.api.dto.sysLog.response.SysLogResponseDTO;
import com.qianxun.admin.api.entity.SysLog;
import com.qianxun.admin.provider.service.SysLogService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysLog.SysLogOuterClass;
import com.qianxun.grpc.lib.sysLog.SysLogServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

/**
 * @author Cloudy
 * Date 2019-05-13 17:03:04
 */
@GrpcService(SysLogOuterClass.class)
@AllArgsConstructor
public class GrpcSysLogService extends SysLogServiceGrpc.SysLogServiceImplBase {
    private final SysLogService sysLogService;
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();

    @Override
    public void getById(SysLogOuterClass.ByIdReq request,
                        StreamObserver<SysLogOuterClass.SysLog> responseObserver) {
        SysLog sysLog = sysLogService.getById(request.getId());
        SysLogOuterClass.SysLog res = ProtoBufUtils.toProtoBuffer(sysLog, SysLogOuterClass.SysLog.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysLogOuterClass.GetListReq request,
                        StreamObserver<SysLogOuterClass.PageList> responseObserver) {
        SysLogQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysLogQueryInputDTO.class);
        IPage<SysLog> page = new Page<SysLog>(inputDTO.getPage(), inputDTO.getPageSize());
        IPage pageList;
        if (inputDTO.getQuery() == null || inputDTO.getQuery().equals("")) {
            pageList = sysLogService.page(page);
        } else {
            pageList = sysLogService.page(page, Wrappers.<SysLog>query().lambda()
                    .like(SysLog::getException, inputDTO.getQuery())
                    .or()
                    .like(SysLog::getUpdatedAt, inputDTO.getQuery())
            );
        }
        SysLogResponseDTO dto = new SysLogResponseDTO();
        dto.setTotal((int) pageList.getTotal());
        dto.setSysLogs(pageList.getRecords());
        SysLogOuterClass.PageList res = ProtoBufUtils.toProtoBuffer(dto, SysLogOuterClass.PageList.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void insert(SysLogOuterClass.BaseSysLog request,
                       StreamObserver<SysLogOuterClass.Result> responseObserver) {
        SysLog sysLog = ProtoBufUtils.fromProtoBuffer(request, SysLog.class);
        responseDTO.setSuccess(sysLogService.save(sysLog));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysLogOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysLogOuterClass.SysLog request,
                       StreamObserver<SysLogOuterClass.Result> responseObserver) {
        SysLog sysLog = ProtoBufUtils.fromProtoBuffer(request, SysLog.class);
        responseDTO.setSuccess(sysLogService.updateById(sysLog));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysLogOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysLogOuterClass.ByIdReq request,
                       StreamObserver<SysLogOuterClass.Result> responseObserver) {
        responseDTO.setSuccess(sysLogService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysLogOuterClass.Result.class));
        responseObserver.onCompleted();
    }
}
