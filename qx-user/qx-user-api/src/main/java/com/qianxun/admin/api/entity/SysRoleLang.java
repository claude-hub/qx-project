package com.qianxun.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Cloudy
 * Date: 2019/5/12 10:27
 */
@Data
public class SysRoleLang  implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer roleId;

    private Integer langId;

    private String name;

    private String roleDesc;
}
