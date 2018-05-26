//package com.qianxun.service.config;
//
//import com.qianxun.entity.SysUser;
//import com.qianxun.service.ISysUserService;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class HeaderTokenWebFilter extends OncePerRequestFilter {
//    private String HEADER_STRING = "Authorization";
//    private String TOKEN_PREFIX = "Bearer";
//
//    ISysUserService iSysUserService;
//
//    HeaderTokenWebFilter(ISysUserService iSysUserService) {
//        this.iSysUserService = iSysUserService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        // 获取header中的令牌或参数中的令牌
//        String accessToken = request.getHeader(HEADER_STRING);
//        if (accessToken == null) {
//            accessToken = request.getParameter("token");
//        }
//        if (accessToken.isEmpty()) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = accessToken.replace("${TOKEN_PREFIX} ", "");
//
//        // 通过数据库验证
//        SysUser user = iSysUserService.signIn(token);
//
////        if (null != user) {
////            request.setAttribute("currentUser", user);
////            val authentication = JWTAuthenticationToken(user)
////            SecurityContextHolder.getContext().setAuthentication(authentication)
////        }
////        filterChain.doFilter(request, response);
//    }
//}
