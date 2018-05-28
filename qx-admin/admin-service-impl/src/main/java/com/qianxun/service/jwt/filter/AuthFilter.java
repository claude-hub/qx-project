package com.qianxun.service.jwt.filter;

import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysUserService;
import com.qianxun.service.jwt.JWTAuthenticationToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对客户端请求的jwt token验证过滤器
 */
public class AuthFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    private ISysUserService iSysUserService;

    private String HEADER_STRING = "Authorization";
    private String TOKEN_PREFIX = "Bearer";

    public AuthFilter(ISysUserService iSysUserService){
        this.iSysUserService = iSysUserService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {

        // 获取header中的令牌或参数中的令牌
        String accessToken = request.getHeader(HEADER_STRING);
        if(accessToken == null){
            accessToken = request.getParameter("token");
            if(accessToken == null){
                chain.doFilter(request, response);
                return;
            }
        }
        String token = accessToken;
        if (accessToken != null && accessToken.startsWith("Bearer ")) {
            token = accessToken.substring(7);
        }

        // 通过数据库验证
        SysUser user = iSysUserService.signIn(token);

        if (null != user) {
            request.setAttribute("currentUser", user);
            JWTAuthenticationToken authentication = new JWTAuthenticationToken(user);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}