package com.qianxun.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.io.Serializable;

/**
 * @author Cloudy
 * Date 2019-05-13 22:03:31
 */
@Data
public class SysDeptLang implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer deptId;

    private Integer langId;

    private String name;
}
