package com.qianxun.admin.provider.service.dept;

import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.admin.provider.service.SysDeptService;
import com.qianxun.grpc.lib.dept.GrpcDeptGrpc;
import com.qianxun.grpc.lib.dept.GrpcDeptOuterClass;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/5/3 20:28
 */
@GrpcService(GrpcDeptOuterClass.class)
public class GrpcDeptService extends GrpcDeptGrpc.GrpcDeptImplBase{
    @Autowired
    private SysDeptService sysDeptService;

    @Override
    public void getDept(GrpcDeptOuterClass.DeptReq request, StreamObserver<GrpcDeptOuterClass.DeptRes> responseObserver){
        responseObserver.onNext(getDept(request));
        responseObserver.onCompleted();
    }
    public void getDeptList(GrpcDeptOuterClass.DeptReq request,
                            StreamObserver<GrpcDeptOuterClass.DeptRes> responseObserver) {
        List<SysDept> sysDeptList =  sysDeptService.findAllSysDepts();
        for (SysDept sysDept: sysDeptList) {
            responseObserver.onNext(GrpcDeptOuterClass.DeptRes.newBuilder()
                    .setId(sysDept.getId())
                    .setParentId(sysDept.getParentId())
                    .setDbSource(sysDept.getDbSource())
//                    .setCreatedAt(sysDept.getCreatedAt())
                    .setCreatedAt(Timestamps.fromMillis(sysDept.getCreatedAt().getTime()))
                    .setUpdatedAt(Timestamp.newBuilder().setSeconds(sysDept.getUpdatedAt().getTime()).build())
                    .build());
        }
        responseObserver.onCompleted();
    }

    private GrpcDeptOuterClass.DeptRes getDept(GrpcDeptOuterClass.DeptReq deptReq){
        SysDept sysDept = sysDeptService.getSysDept(deptReq.getId());
        return GrpcDeptOuterClass.DeptRes.newBuilder()
                .setId(sysDept.getId())
//                .setSort(sysDept.getSort())
//                .setDbSource(sysDept.getDbSource())
                .setParentId(sysDept.getParentId())
                .build();
    }
}
