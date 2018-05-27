package com.qianxun.admin.jwt.filter;

import com.qianxun.admin.jwt.properties.JwtProperties;
import com.qianxun.admin.jwt.util.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {

        //获取request中的json字符串。如"{\n "name":"cloudy",\n "token":"test"\n}"
//        String jsonStr = getRequestJsonStr(request);

        // 获取header中的令牌或参数中的令牌
        String accessToken = request.getHeader(jwtProperties.getHeader());
        if(accessToken == null){
            accessToken = request.getParameter("token");
            if(accessToken == null){
                chain.doFilter(request, response);
                return;
            }
        }
        String authToken = null;
        if (accessToken != null && accessToken.startsWith("Bearer ")) {
            authToken = accessToken.substring(7);

            //获取用户名
//            String userName = jwtTokenUtil.getUserNameFromToken(authToken);
//            System.out.println(userName);

            //验证token是否过期,包含了验证jwt是否正确
            try {
                boolean flag = jwtTokenUtil.isTokenExpired(authToken);
                if (flag) {
                    throw new ServletException("token过期");
                }
            } catch (JwtException e) {
                //有异常就是token解析失败
                throw new ServletException("token验证失败");
            }
        } else {
            //header没有带Bearer字段
            throw new ServletException("header没有带Bearer字段");
        }
        chain.doFilter(request, response);
    }

    /**
     * 获取request中的json字符串
     * @param request
     * @return
     * @throws IOException
     */
    private String getRequestJsonStr(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes("iso-8859-1"),
                    "utf-8").replaceAll("%22", "\"");
            // POST
        } else {
            return getRequestPostStr(request);
        }
    }

    /**
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException
     */
    public String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }
    /**
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException
     */
    public byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
}