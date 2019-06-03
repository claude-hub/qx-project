package com.qianxun.admin.provider.grpc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysOrder.request.SysOrderQueryInputDTO;
import com.qianxun.admin.api.dto.sysOrder.response.SysOrderResponseDTO;
import com.qianxun.admin.api.entity.SysOrder;
import com.qianxun.admin.provider.service.SysOrderService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass;
import com.qianxun.grpc.lib.sysOrder.SysOrderServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

/**
 * @author Cloudy
 *  */
@GrpcService(SysOrderOuterClass.class)
@AllArgsConstructor
public class GrpcSysOrderService extends SysOrderServiceGrpc.SysOrderServiceImplBase {
    private final SysOrderService sysOrderService;
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();

    @Override
    public void getById(SysOrderOuterClass.ByIdReq request,
                        StreamObserver<SysOrderOuterClass.SysOrder> responseObserver) {
        SysOrder sysOrder = sysOrderService.getById(request.getId());
        SysOrderOuterClass.SysOrder res = ProtoBufUtils.toProtoBuffer(sysOrder, SysOrderOuterClass.SysOrder.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysOrderOuterClass.GetListReq request,
                        StreamObserver<SysOrderOuterClass.PageList> responseObserver) {
        SysOrderQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysOrderQueryInputDTO.class);
        IPage<SysOrder> page = new Page<SysOrder>(inputDTO.getPage(),inputDTO.getPageSize());
        IPage pageList;
        if(inputDTO.getQuery() == null || inputDTO.getQuery().equals("")){
            pageList = sysOrderService.page(page);
        }else {
            pageList = sysOrderService.page(page, Wrappers.<SysOrder>query().lambda()
                    .and(item -> item
                                                                                                                                                                                                     .like(SysOrder::getName, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysOrder::getCreatedAt, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysOrder::getUpdatedAt, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                             .like(SysOrder::getDeleted, inputDTO.getQuery())
                                         .or()
                                                                                                                                                                                                            .like(SysOrder::getVersion, inputDTO.getQuery())
                                                                                                                    )

            );
        }
        SysOrderResponseDTO dto = new SysOrderResponseDTO();
        dto.setTotal((int) pageList.getTotal());
        dto.setSysOrders(pageList.getRecords());
        SysOrderOuterClass.PageList res = ProtoBufUtils.toProtoBuffer(dto, SysOrderOuterClass.PageList.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void insert(SysOrderOuterClass.BaseSysOrder request,
                       StreamObserver<SysOrderOuterClass.Result> responseObserver) {
        SysOrder sysOrder = ProtoBufUtils.fromProtoBuffer(request, SysOrder.class);
        responseDTO.setSuccess(sysOrderService.save(sysOrder));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysOrderOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysOrderOuterClass.SysOrder request,
                       StreamObserver<SysOrderOuterClass.Result> responseObserver) {
        SysOrder sysOrder = ProtoBufUtils.fromProtoBuffer(request, SysOrder.class);
        responseDTO.setSuccess(sysOrderService.updateById(sysOrder));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysOrderOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysOrderOuterClass.ByIdReq request,
                       StreamObserver<SysOrderOuterClass.Result> responseObserver) {
        responseDTO.setSuccess(sysOrderService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysOrderOuterClass.Result.class));
        responseObserver.onCompleted();
    }
}
