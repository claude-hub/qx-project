//package com.qianxun.service.config;
//
//import com.qianxun.entity.SysPermission;
//import com.qianxun.entity.SysUser;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//public class JWTAuthenticationToken extends AbstractAuthenticationToken {
//
//    private SysUser user;
//    private List<SimpleGrantedAuthority> authorities;
//
//    public JWTAuthenticationToken(Collection<? extends SimpleGrantedAuthority> authorities) {
//        super(authorities);
//        for(SysPermission permission : this.user.getPermissions()) {
//            this.authorities.add(new SimpleGrantedAuthority(permission.getKey()));
//        }
//    }
//
//    @Override
//    public Object getCredentials() {
//        return this.user;
//    }
//
//    @Override
//    public List<SimpleGrantedAuthority> getPrincipal() {
//        return this.authorities;
//    }
//}
