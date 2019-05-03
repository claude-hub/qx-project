package com.qianxun.admin.provider.service.dept;

import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.admin.provider.service.SysDeptService;
import com.qianxun.grpc.lib.dept.DeptReq;
import com.qianxun.grpc.lib.dept.DeptRes;
import com.qianxun.grpc.lib.dept.GrpcDeptGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/5/3 20:28
 */
@GrpcService(GrpcDeptGrpc.class)
public class GrpcDeptService extends GrpcDeptGrpc.GrpcDeptImplBase{
    @Autowired
    private SysDeptService sysDeptService;

    @Override
    public void getDept(DeptReq request, StreamObserver<DeptRes> responseObserver){
        responseObserver.onNext(getDept(request));
        responseObserver.onCompleted();
    }
    public void getDeptList(DeptReq request,
                            StreamObserver<DeptRes> responseObserver) {
        List<SysDept> sysDeptList =  sysDeptService.findAllSysDepts();
        for (SysDept sysDept: sysDeptList) {
            responseObserver.onNext(DeptRes.newBuilder()
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

    private DeptRes getDept(DeptReq deptReq){
        SysDept sysDept = sysDeptService.getSysDept(deptReq.getId());
        return DeptRes.newBuilder()
                .setId(sysDept.getId())
//                .setSort(sysDept.getSort())
//                .setDbSource(sysDept.getDbSource())
                .setParentId(sysDept.getParentId())
                .build();
    }
}


//@Slf4j
//@GrpcService(GreeterOuterClass.class)
//public class GreeterService extends GreeterGrpc.GreeterImplBase {
//    @Override
//    public void sayHello(GreeterOuterClass.HelloRequest request, StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
//        String message = "Hello 8001" + request.getName();
//        final GreeterOuterClass.HelloReply.Builder replyBuilder = GreeterOuterClass.HelloReply.newBuilder().setMessage(message);
//        responseObserver.onNext(replyBuilder.build());
//        responseObserver.onCompleted();
//        log.info("Returning " +message);
//    }
//}

//    /**
//     */
//    public void getDept(com.qianxun.grpc.lib.dept.DeptReq request,
//                        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.DeptRes> responseObserver) {
//        asyncUnimplementedUnaryCall(getGetDeptMethod(), responseObserver);
//    }
//
//    /**
//     */
//    public void getDeptList(com.qianxun.grpc.lib.dept.DeptReq request,
//                            io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.DeptListRes> responseObserver) {
//        asyncUnimplementedUnaryCall(getGetDeptListMethod(), responseObserver);
//    }
//
//    /**
//     */
//    public void updateDept(com.qianxun.grpc.lib.dept.DeptRes request,
//                           io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.UpdateDeptRes> responseObserver) {
//        asyncUnimplementedUnaryCall(getUpdateDeptMethod(), responseObserver);
//    }
//
//    /**
//     */
//    public void deleteDept(com.qianxun.grpc.lib.dept.DeptReq request,
//                           io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.UpdateDeptRes> responseObserver) {
//        asyncUnimplementedUnaryCall(getDeleteDeptMethod(), responseObserver);
//    }
