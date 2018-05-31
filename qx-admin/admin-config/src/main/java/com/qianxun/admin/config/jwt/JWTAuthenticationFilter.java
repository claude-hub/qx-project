package com.qianxun.admin.config.jwt;

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
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private String HEADER_STRING = "Authorization";
    private String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {

        // 获取header中的令牌或参数中的令牌
        String accessToken = request.getHeader(HEADER_STRING);
        if (accessToken == null) {
            accessToken = request.getParameter("token");
            if (accessToken == null) {
                chain.doFilter(request, response);
                return;
            }
        }
        String token = accessToken;
        if (accessToken != null && accessToken.startsWith(TOKEN_PREFIX)) {
            token = accessToken.substring(7);
        }
        JWTAuthenticationToken authentication = new JWTAuthenticationToken(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}