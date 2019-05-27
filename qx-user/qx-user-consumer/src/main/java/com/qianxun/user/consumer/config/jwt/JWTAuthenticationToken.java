package com.qianxun.user.consumer.config.jwt;

import cn.hutool.core.util.ArrayUtil;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.entity.SysUser;
import com.qianxun.user.consumer.grpc.client.GrpcAuthUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.*;


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

    public JWTAuthenticationToken(SysUserDTO user) {
        super(null);
        this.credentials = user.getCurrentToken();
        Set<String> dbAuthsSet = new HashSet<>();
        Integer[] roles = user.getRoles().toArray(new Integer[0]);
        if (ArrayUtil.isNotEmpty(roles)) {
            // 获取角色
            Arrays.stream(roles).forEach(role -> dbAuthsSet.add("ROLE_" + role));
            // 获取资源
            dbAuthsSet.addAll(user.getPermissions());
        }
        authorities =
                AuthorityUtils.createAuthorityList(dbAuthsSet.toArray(new String[0]));

        this.principal = user;
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
