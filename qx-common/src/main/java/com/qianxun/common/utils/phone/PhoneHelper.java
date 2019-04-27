package com.qianxun.common.utils.phone;

import com.qianxun.common.utils.exception.PhoneException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * 手机工具类
 */
@Component
public class PhoneHelper {

    private static PhoneHelper phoneHelper = new PhoneHelper();

    @Bean
    public static PhoneHelper getPhoneHelper() {
        return phoneHelper;
    }
    /**
     * 验证手机号（精确）
     *
     * @param input 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    /**
     * 正则：手机号（精确）
     * <p>移动：134(0-8)、135、136、137、138、139、147、150、151、152、
     *    157、158、159、178、182、183、184、187、188、198</p>
     * <p>联通：130、131、132、145、155、156、175、176、185、186、166</p>
     * <p>电信：133、153、173、177、180、181、189、199</p>
     * <p>全球星：1349</p>
     * <p>虚拟运营商：170</p>
     */
    private final String REGEX_MOBILE_EXACT = "^((13[0-9])|(14[5,7])|" +
            "(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";

    public void isMobileExact(CharSequence input) throws PhoneException {
        if(!isMatch(REGEX_MOBILE_EXACT, input)){
            throw new PhoneException("手机号不正确");
        }
    }

    private boolean isMatch(String regex, CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }
}