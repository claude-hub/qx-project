package com.qianxun.admin.api.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cloudy
 * @date 2019-05-07 21:51:21
 */
@Data
public class SysLang implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 语言名
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 0--正常 -1--删除
     */
    private Integer status = 0;
    /**
     *
     */
    private String dbSource = "";
}
