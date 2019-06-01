package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.authUser.AuthUserLoginInputDTO;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.authUser.AuthUserOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcAuthUserClient;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Cloudy
 * Date: 2019/5/27 21:56
 */
@RestController
@RequestMapping(value = "/auth")
@AllArgsConstructor
public class AuthUserController {
    private final GrpcAuthUserClient grpcAuthUserClient;

    /**
     * 登录
     */
    @SneakyThrows
    @PostMapping("/sign_in")
    public JSONResult sign_in(@Valid AuthUserLoginInputDTO input) {
        JSONResult data = new JSONResult();
        AuthUserOuterClass.SignInReq signInReq = ProtoBufUtils.toProtoBuffer(input, AuthUserOuterClass.SignInReq.class);
        SysUserDTO sysUserDTO = grpcAuthUserClient.signIn(signInReq);
        if(sysUserDTO.getId() == null){
            throw new Exception("用户名或密码不正确!");
        }
        data.setData(sysUserDTO);
        return data;
    }
}
