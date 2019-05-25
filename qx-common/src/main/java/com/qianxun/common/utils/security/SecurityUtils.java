package com.qianxun.common.utils.security;

import cn.hutool.core.util.StrUtil;
import com.qianxun.common.utils.security.user.QxUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/5/25 14:57
 */
@UtilityClass
public class SecurityUtils {

    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public QxUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof QxUser) {
            return (QxUser) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public QxUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    public String getUsername() {
        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();
        return principal.toString();
    }

    /**
     * 获取用户角色信息
     *
     * @return 角色集合
     */
    public List<Integer> getRoles() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<Integer> roleIds = new ArrayList<>();
        authorities.stream()
                .filter(granted -> StrUtil.startWith(granted.getAuthority(), "ROLE_"))
                .forEach(granted -> {
                    String id = StrUtil.removePrefix(granted.getAuthority(), "ROLE_");
                    roleIds.add(Integer.parseInt(id));
                });
        return roleIds;
    }
}
