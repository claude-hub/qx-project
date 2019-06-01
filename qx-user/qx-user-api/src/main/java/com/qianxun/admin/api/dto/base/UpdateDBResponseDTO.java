package com.qianxun.admin.api.dto.base;

import lombok.Data;
import java.io.Serializable;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/09/19 10:30
 */
@Data
public class UpdateDBResponseDTO implements Serializable {
    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 返回消息
     */
    private String message;
}
