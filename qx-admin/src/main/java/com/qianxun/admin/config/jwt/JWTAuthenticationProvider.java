package com.qianxun.admin.config.jwt;

import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.service.AuthUserService;
import com.qianxun.admin.service.SysUserService;
import com.qianxun.common.utils.jwt.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
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
public class JWTAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthUserService authUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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
        SysUser user = authUserService.signIn(token);
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
