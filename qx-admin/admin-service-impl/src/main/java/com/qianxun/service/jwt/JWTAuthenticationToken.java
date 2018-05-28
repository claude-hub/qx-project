package com.qianxun.service.jwt;

import com.qianxun.entity.SysUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JWTAuthenticationToken extends AbstractAuthenticationToken {
    private SysUser user;

    public JWTAuthenticationToken(SysUser user) {
        super(null);
        this.user = user;
    }
    @Override
    public String getCredentials() {
        return user.getCurrentToken();
    }

    @Override
    public SysUser getPrincipal() {
        return user;
    }
}
