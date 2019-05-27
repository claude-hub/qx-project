package com.qianxun.user.consumer.config.jwt;

import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.common.utils.jwt.JwtTokenUtil;
import com.qianxun.grpc.lib.authUser.AuthUserOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcAuthUserClient;
import io.jsonwebtoken.JwtException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 认证JWT
 */
@Component
@AllArgsConstructor
public class JWTAuthenticationProvider implements AuthenticationProvider {

    private final GrpcAuthUserClient grpcAuthUserClient;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        if (auth.isAuthenticated())
            return auth;
        String token = auth.getCredentials().toString();
        try {
            //验证token格式是否正确
            jwtTokenUtil.parseToken(token);
            //验证token是否过期
            boolean flag = jwtTokenUtil.isTokenExpired(token);
            if (flag) {
                throw new CredentialsExpiredException("JWT证书过期");
            }
        } catch (JwtException e) {
            throw new BadCredentialsException("JWT证书格式错误");
        }
        SysUserDTO user = grpcAuthUserClient.signIn(
                AuthUserOuterClass.SignInByTokenReq.newBuilder()
                        .setToken(token).build());
        //认证用户
        JWTAuthenticationToken authentication = null;
        if (user != null) {
            authentication = new JWTAuthenticationToken(user);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            throw new BadCredentialsException("无效的JWT证书");
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
