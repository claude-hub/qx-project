package com.qianxun.admin.api.dto.extend;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Cloudy
 */
@Data
public class SysMenuDTO extends TreeNode{
    /**
     * 菜单权限标识
     */
    private String permission;
    /**
     * VUE页面
     */
    private String component;
    /**
     * 前端URL
     */
    private String path;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序值
     */
    private Integer sort = 0;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private Integer type = 0;
    /**
     * 0-开启，1- 关闭
     */
    private Integer keepAlive;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    /**
     * 0--正常 -1--删除
     */
    private Integer deleted;
}
