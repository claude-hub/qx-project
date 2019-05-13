package com.qianxun.admin.api.dto.extend;

import com.qianxun.admin.api.entity.SysDept;
import lombok.Data;

/**
 * @author Cloudy
 * Date: 2019/5/12 10:14
 */
@Data
public class SysDeptDTO extends SysDept {
    /**
     * 部门名
     */
    private String name;

    /**
     * 语言Id
     */
    private Integer langId;
}
