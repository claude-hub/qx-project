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
 * Date 2019-05-13 19:35:18
 */
@Data
public class SysRole implements Serializable {
    /**
     * 角色ID
     */
    /* 必须设置自动递增，不然底层会生成一个很大的数字，如：1126698029325058050 */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色码
     */
    private String roleCode;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    /**
     * 更新时间
     * 乐观锁
     */
    @Version
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    /**
     * 1-正常，-1-删除
     */
    @TableLogic
    private Integer deleted;
}
