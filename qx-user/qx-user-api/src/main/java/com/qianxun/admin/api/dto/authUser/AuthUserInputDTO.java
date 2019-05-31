package com.qianxun.admin.api.dto.authUser;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Cloudy
 * Date: 2019/5/17 12:51
 */
@Data
public class AuthUserInputDTO implements Serializable {
    /**
     * 单点登录时，用账号查询
     */
    private String account;
}
