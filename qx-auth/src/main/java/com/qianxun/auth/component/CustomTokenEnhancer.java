package com.qianxun.auth.component;

import com.qianxun.auth.constant.SecurityConstants;
import com.qianxun.auth.service.QxUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cloudy
 * Date: 2019/5/5 21:39
 * 添加token额外信息
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        QxUser user = (QxUser) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("license", SecurityConstants.PROJECT_LICENSE);
        // 注意添加的额外信息，最好不要和已有的json对象中的key重名，容易出现错误
        additionalInfo.put("user_id", user.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
