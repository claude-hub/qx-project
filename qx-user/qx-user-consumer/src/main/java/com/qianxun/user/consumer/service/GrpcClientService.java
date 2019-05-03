package com.qianxun.user.consumer.service;

import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.grpc.lib.GreeterGrpc;
import com.qianxun.grpc.lib.GreeterOuterClass;
import com.qianxun.grpc.lib.dept.DeptReq;
import com.qianxun.grpc.lib.dept.DeptRes;
import com.qianxun.grpc.lib.dept.GrpcDeptGrpc;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/4/27 20:27
 */
@Service
public class GrpcClientService {

    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public String sendMessage(String name) {
        GreeterGrpc.GreeterBlockingStub stub= GreeterGrpc.newBlockingStub(serverChannel);
        GreeterOuterClass.HelloReply response = stub.sayHello(GreeterOuterClass.HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }

    public SysDept getDeptById(int id) {
        GrpcDeptGrpc.GrpcDeptBlockingStub stub = GrpcDeptGrpc.newBlockingStub(serverChannel);
        DeptRes res = stub.getDept(DeptReq.newBuilder().setId(id).build());
       return grpcToDept(res);
    }


    public List<SysDept> getDeptList() {
        GrpcDeptGrpc.GrpcDeptBlockingStub stub = GrpcDeptGrpc.newBlockingStub(serverChannel);
        Iterator<DeptRes> deptResIterator;
        List<SysDept> sysDeptList = new ArrayList<>();
        try {
            deptResIterator = stub.getDeptList(DeptReq.newBuilder().build());
            for (int i = 1; deptResIterator.hasNext(); i++) {
                DeptRes deptRes = deptResIterator.next();
                SysDept sysDept = grpcToDept(deptRes);
                sysDeptList.add(sysDept);
//                Feature feature = features.next();
//                info("Result #" + i + ": {0}", feature);
//                if (testHelper != null) {
//                    testHelper.onMessage(feature);
//                }
            }
        }catch (StatusRuntimeException e) {
//            warning("RPC failed: {0}", e.getStatus());
//            if (testHelper != null) {
//                testHelper.onRpcError(e);
//            }
        }
        return sysDeptList;
    }

    private SysDept grpcToDept (DeptRes deptRes){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        SysDept sysDept = new SysDept();
        sysDept.setId(deptRes.getId());
        sysDept.setParentId(deptRes.getParentId());
        sysDept.setDbSource(deptRes.getDbSource());
        sysDept.setCreatedAt(new Date(deptRes.getCreatedAt().getSeconds()*1000));
//        sysDept.setCreatedAt(deptRes.getCreatedAt());
        sysDept.setUpdatedAt(new Date(deptRes.getUpdatedAt().getSeconds()));
        return sysDept;
    }
}
