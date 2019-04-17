package com.qianxun.admin.controller;

import com.qianxun.admin.grpc.client.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/query")
    public String query() {
        return "hello test";
    }

    @Autowired
    private LoginClient loginClient;

    @GetMapping("/test")
    public void testSayHello() {
        loginClient.login("admin", "123456");
    }
}
