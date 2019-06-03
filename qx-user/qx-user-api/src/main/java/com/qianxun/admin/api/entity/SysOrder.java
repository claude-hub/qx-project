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
 *  */
@Data
public class SysOrder implements Serializable {
    /**
     * 序号
     */
        @TableId(value = "id", type = IdType.AUTO)
                    private Integer id;
    /**
     * 订单名
     */
                    private String name;
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
     * 是否删除  -1：已删除  0：正常
     */
                @TableLogic
            private Integer deleted;
    /**
     * 乐观锁
     */
                    @Version
        private Integer version;
}
