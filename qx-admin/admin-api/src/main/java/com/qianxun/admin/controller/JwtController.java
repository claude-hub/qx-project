package com.qianxun.admin.controller;

import com.qianxun.admin.jwt.dto.AuthRequest;
import com.qianxun.admin.jwt.dto.AuthResponse;
import com.qianxun.admin.jwt.IReqValidator;
import com.qianxun.admin.jwt.util.JwtTokenUtil;
import com.qianxun.admin.jwt.dto.TestInputDTO;
import com.qianxun.utils.JSONResult;
import com.qianxun.utils.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 请求验证的
 */
@RestController
//@RequestMapping(value = "jwt")
public class JwtController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;

    @PostMapping("/auth")
    public JSONResult createAuthenticationToken(@RequestBody @Valid AuthRequest authRequest) throws BusinessException {
        JSONResult data = new JSONResult();
        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            AuthResponse response = new AuthResponse();
            response.setToken(token);
            response.setRandomKey(randomKey);

            data.setData(response);
            return data;
        } else {
            throw new BusinessException("账号密码错误");
        }
    }
    @PostMapping("/test_jwt")
    public JSONResult testJwt(@RequestBody @Valid @ModelAttribute TestInputDTO testInputDTO) {
        JSONResult data = new JSONResult();
        data.setData(testInputDTO);
        return data;
    }
}

