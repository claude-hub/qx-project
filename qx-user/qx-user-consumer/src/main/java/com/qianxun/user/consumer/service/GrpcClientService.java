package com.qianxun.user.consumer.service;

import com.qianxun.grpc.lib.GreeterGrpc;
import com.qianxun.grpc.lib.GreeterOuterClass;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

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
}
