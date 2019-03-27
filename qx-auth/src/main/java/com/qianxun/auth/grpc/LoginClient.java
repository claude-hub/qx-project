package com.qianxun.auth.grpc;

import com.qianxun.auth.grpc.login.LoginReq;
import com.qianxun.auth.grpc.login.LoginRes;
import com.qianxun.auth.grpc.login.LoginServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class LoginClient {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoginClient.class);

    private LoginServiceGrpc.LoginServiceBlockingStub loginServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 6565).usePlaintext().build();

        loginServiceBlockingStub =
                LoginServiceGrpc.newBlockingStub(managedChannel);
    }

    public String login(String account, String password) {
        LoginReq user = LoginReq.newBuilder().setAccount(account)
                .setPassword(password).build();
        LOGGER.info("client sending {}", user);

        LoginRes res =
                loginServiceBlockingStub.login(user);
        LOGGER.info("client received {}", res);

        return res.getMessage();
    }
}
