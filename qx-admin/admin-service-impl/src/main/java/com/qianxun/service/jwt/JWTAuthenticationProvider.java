package com.qianxun.service.jwt;

import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * 认证JWT
 */
@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ISysUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.isAuthenticated())
            return authentication;

        String token = authentication.getCredentials().toString();

        SysUser user = userService.signIn(token);

        if (user != null) {
            Authentication auth = new JWTAuthenticationToken(user);
            auth.setAuthenticated(true);
            return auth;
        } else
            throw new BadCredentialsException("无效的Token");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
