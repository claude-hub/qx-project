package com.qianxun.auth.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Cloudy
 * Date: 2019/5/5 17:27
 */
public class QxUser extends User implements Serializable {
    /**
     * 用户ID
     */
    @Getter
    private Integer id;
    /**
     * 部门ID
     */
    @Getter
    private Integer deptId;

    public QxUser(Integer id, Integer deptId, String username, String password, boolean enabled,
                  boolean accountNonExpired, boolean credentialsNonExpired,
                  boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
        this.id = id;
        this.deptId = deptId;
    }
}
