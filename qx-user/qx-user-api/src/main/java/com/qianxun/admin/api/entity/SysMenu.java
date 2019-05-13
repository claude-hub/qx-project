package com.qianxun.admin.api.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Cloudy
 * Date 2019-05-13 14:37:45
 */
@Data
public class SysMenu implements Serializable {
    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父菜单ID
     */
    private Integer parentId;
    /**
     * 菜单权限标识
     */
    private String menuCode;
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
    private Integer sort;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private Integer type;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    /**
     * 更新时间
     */
    @Version
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    /**
     * 0--正常 -1--删除
     */
    @TableLogic
    private Integer deleted;
}
