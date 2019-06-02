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
public class SysRoleMenu implements Serializable {
    /**
     * 
     */
        @TableId(value = "id", type = IdType.AUTO)
                private Integer id;
    /**
     * 
     */
                private Integer roleId;
    /**
     * 
     */
                private Integer menuId;
}
