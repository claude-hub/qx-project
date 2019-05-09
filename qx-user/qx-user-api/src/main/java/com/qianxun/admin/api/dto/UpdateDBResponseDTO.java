package com.qianxun.admin.api.dto;

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
     * 插入的id，或者受影响的行数
     */
    private Integer result;
}
