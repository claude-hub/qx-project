package com.qianxun.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Cloudy
 * Date 2019-05-13 14:37:45
 */
@Data
public class SysMenuLang implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer MenuId;

    private Integer langId;

    private String name;
}
