//package com.qianxun.service.shiro;
//
//import com.qianxun.entity.SysUser;
//import com.qianxun.mapper.SysUserMapper;
//import com.qianxun.service.exception.UserNotFoundException;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.crypto.hash.Md5Hash;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class ShiroDbRealm extends AuthorizingRealm {
//    @Autowired
//    private SysUserMapper sysUserMapper;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        return null;
//    }
//
//    /**
//     * 登录认证
//     * @param authcToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//        SysUser user = sysUserMapper.selectByLoginStr(token.getUsername());
//        if (user == null) {
//            throw new UnknownAccountException("用户不存在");
//        }
//        if (user.getStatus() == 1) {
//            throw new LockedAccountException("用户被冻结");
//        }
//        String credentials = user.getPasswordEncrypted();
//        // 密码加盐处理
//        String source = user.getPasswordSalt();
//        ByteSource credentialsSalt = new Md5Hash(source);
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, credentials, credentialsSalt, super.getName());
//        return info;
//    }
//}
