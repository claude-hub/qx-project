package com.qianxun.admin.provider.grpc.service.sysDept;

/**
 * @author Cloudy
 * Date: 2019-05-13 00:37:19
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.extend.SysDeptDTO;
import com.qianxun.admin.api.dto.sysDept.request.SysDeptQueryInputDTO;
import com.qianxun.admin.api.dto.sysDept.response.SysDeptResponseDTO;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.admin.provider.service.SysDeptService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysDept.SysDeptOuterClass;
import com.qianxun.grpc.lib.sysDept.SysDeptServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

/**
 * @author Cloudy
 * Date: 2019-05-13 00:37:19
 */
@GrpcService(SysDeptOuterClass.class)
@AllArgsConstructor
public class GrpcSysDeptService extends SysDeptServiceGrpc.SysDeptServiceImplBase {
    private final SysDeptService sysDeptService;
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();

    @Override
    public void getById(SysDeptOuterClass.ByIdReq request,
                        StreamObserver<SysDeptOuterClass.SysDept> responseObserver) {
        SysDept sysDept = sysDeptService.getById(request.getId());
        SysDeptOuterClass.SysDept res = ProtoBufUtils.toProtoBuffer(sysDept, SysDeptOuterClass.SysDept.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysDeptOuterClass.GetListReq request,
                        StreamObserver<SysDeptOuterClass.PageList> responseObserver) {
        SysDeptQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysDeptQueryInputDTO.class);
        Page page = new Page(inputDTO.getPage(), inputDTO.getPageSize());
        IPage pageList = sysDeptService.getSysDepts(page, inputDTO);
        SysDeptResponseDTO dto = new SysDeptResponseDTO();
        dto.setTotal((int) pageList.getTotal());
        dto.setSysDepts(pageList.getRecords());
        SysDeptOuterClass.PageList res = ProtoBufUtils.toProtoBuffer(dto, SysDeptOuterClass.PageList.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void insert(SysDeptOuterClass.BaseSysDept request,
                       StreamObserver<SysDeptOuterClass.Result> responseObserver) {
        SysDeptDTO sysDeptDTO = ProtoBufUtils.fromProtoBuffer(request, SysDeptDTO.class);
        responseDTO.setSuccess(sysDeptService.saveSysDept(sysDeptDTO));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysDeptOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysDeptOuterClass.SysDept request,
                       StreamObserver<SysDeptOuterClass.Result> responseObserver) {
        SysDeptDTO sysDeptDTO = ProtoBufUtils.fromProtoBuffer(request, SysDeptDTO.class);
        responseDTO.setSuccess(sysDeptService.updateSysDept(sysDeptDTO));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysDeptOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysDeptOuterClass.ByIdReq request,
                       StreamObserver<SysDeptOuterClass.Result> responseObserver) {
        responseDTO.setSuccess(sysDeptService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysDeptOuterClass.Result.class));
        responseObserver.onCompleted();
    }
}
