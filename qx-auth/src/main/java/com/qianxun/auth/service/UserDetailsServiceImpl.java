package com.qianxun.auth.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Cloudy
 * Date: 2019/5/5 17:08
 */
@Slf4j
@Service
@AllArgsConstructor //替代@Autowired构造注入
public class UserDetailsServiceImpl implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    /**
     * 用户密码登录
     *
     * @param username 用户名
     * @return
     */
    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        Set<String> dbAuthsSet = new HashSet<>();
        dbAuthsSet.add("ROLE_1");
        dbAuthsSet.add("sys_del_user");
        Collection<? extends GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList(dbAuthsSet.toArray(new String[0]));
        return new QxUser(1, 1,username,
                passwordEncoder.encode("123456"),
                true,true,
                true,true,authorities);
    }
}
