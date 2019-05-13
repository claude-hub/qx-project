package com.qianxun.admin.api.dto.extend;

import com.qianxun.admin.api.entity.SysDept;
import lombok.Data;

/**
 * @author Cloudy
 * Date 2019-05-13 22:03:31
 */
@Data
public class SysDeptDTO extends SysDept {
    /**
     * 国际化名称
     */
    private String name;

    /**
     * 语言Id
     */
    private Integer langId;
}
