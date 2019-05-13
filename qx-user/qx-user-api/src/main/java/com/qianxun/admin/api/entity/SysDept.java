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
 * Date 2019-05-13 22:03:31
 */
@Data
public class SysDept implements Serializable {
    /**
     * 
     */
        @TableId(value = "id", type = IdType.AUTO)
                private Integer id;
    /**
     * 
     */
                private Integer parentId;
    /**
     * 
     */
                private Integer sort;
    /**
     * 
     */
                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private Date createdAt;
    /**
     * 
     */
                @Version
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private Date updatedAt;
    /**
     * 是否删除  -1：已删除  0：正常
     */
                @TableLogic
        private Integer deleted;
}
