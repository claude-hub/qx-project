package com.qianxun.admin.config.jwt;

import com.qianxun.admin.model.entity.SysMenu;
import com.qianxun.admin.model.entity.SysRole;
import com.qianxun.admin.model.entity.SysUser;
import com.qianxun.admin.service.AuthUserService;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class JWTAuthenticationToken extends AbstractAuthenticationToken {

    private Collection<GrantedAuthority> authorities;

    private final Object credentials;

    private final Object principal;

    public JWTAuthenticationToken(String token) {
        super(null);
        this.credentials = token;
        this.principal = null;
        setAuthenticated(false);
    }

    public JWTAuthenticationToken(SysUser user) {
        super(null);
        this.credentials = user.getCurrentToken();

        AuthUserService authUserService = AuthUserService.me();
        List<SysMenu> menus = authUserService.getMenusByUserId(user.getUserId());
        List<SysRole> roles = authUserService.getRolesByUserId(user.getUserId());
        user.setMenus(menus);
        user.setRoles(roles);
        this.principal = user;
        authorities = new ArrayList<GrantedAuthority>();
        Iterator<SysMenu> it = menus.iterator();
        while (it.hasNext()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + it.next().getMenuCode()));
        }
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
