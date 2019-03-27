package com.qianxun.auth.grpc;

import com.qianxun.auth.grpc.login.LoginReq;
import com.qianxun.auth.grpc.login.LoginRes;
import com.qianxun.auth.grpc.login.LoginServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class LoginServiceImpl extends LoginServiceGrpc.LoginServiceImplBase {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public void login(LoginReq request,
                         StreamObserver<LoginRes> responseObserver) {
        LOGGER.info("server received {}", request);
        String account = request.getAccount();
        String password = request.getPassword();
        LOGGER.info(account,password);
        LoginRes res = LoginRes.newBuilder().setMessage("success").build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
