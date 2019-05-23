package com.qianxun.sso.service;

import cn.hutool.core.util.ArrayUtil;
import com.qianxun.admin.api.dto.authUser.AuthUserInputDTO;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.authUser.AuthUserOuterClass;
import com.qianxun.sso.constant.SecurityConstants;
import com.qianxun.sso.grpc.GrpcAuthUserClient;
import com.qianxun.sso.user.QxUser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    private final GrpcAuthUserClient grpcAuthUserClient;

    /**
     * 用户密码登录
     *
     * @param username 用户名
     * @return
     */
    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        AuthUserInputDTO input = new AuthUserInputDTO();
        input.setAccount(username);
        AuthUserOuterClass.ByAccountReq req = ProtoBufUtils.toProtoBuffer(input, AuthUserOuterClass.ByAccountReq.class);
        SysUserDTO info = grpcAuthUserClient.getSysUserByAccount(req);
        Set<String> dbAuthsSet = new HashSet<>();
        Integer[] roles = info.getRoles().toArray(new Integer[0]);
        if (ArrayUtil.isNotEmpty(roles)) {
            // 获取角色
            Arrays.stream(roles).forEach(role -> dbAuthsSet.add(SecurityConstants.ROLE + role));
            // 获取资源
            dbAuthsSet.addAll(info.getPermissions());
        }
        Collection<? extends GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList(dbAuthsSet.toArray(new String[0]));
        return  new QxUser(info.getId(), info.getDeptId(),username,
                info.getPasswordEncrypted(),
                true,true,
                true,true,authorities);
    }
}
