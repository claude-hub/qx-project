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
public class SysUser implements Serializable {
    /**
     * 主键ID
     */
        @TableId(value = "id", type = IdType.AUTO)
                private Integer id;
    /**
     * 部门ID
     */
                private Integer deptId;
    /**
     * 姓名
     */
                private String name;
    /**
     * 身份证
     */
                private String identification;
    /**
     * 电话
     */
                private String phone;
    /**
     * 邮箱
     */
                private String email;
    /**
     * 头像
     */
                private String avatar;
    /**
     * 0-正常，-1-冻结
     */
                private Integer locked;
    /**
     * 0-正常，-1-冻结
     */
                @TableLogic
        private Integer deleted;
    /**
     * 用户名
     */
                private String userName;
    /**
     * 重置密码的token
     */
                private String resetPasswordToken;
    /**
     * 加密后的密码
     */
                private String passwordEncrypted;
    /**
     * 创建时间
     */
                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private Date createdAt;
    /**
     * 修改时间
     */
                @Version
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private Date updatedAt;
    /**
     * 当前的token
     */
                private String currentToken;
    /**
     * 当前登录时间
     */
                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private Date currentSignInAt;
    /**
     * 上一次登录时间
     */
                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private Date lastSignInAt;
    /**
     * 累积登录次数
     */
                private Integer signInCount;
}
