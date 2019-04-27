package com.qianxun.user.consumer.controller;

import com.qianxun.user.consumer.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cloudy
 * Date: 2019/4/27 20:31
 */
@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "LinShen") String name) {
        return grpcClientService.sendMessage(name);
    }
}
