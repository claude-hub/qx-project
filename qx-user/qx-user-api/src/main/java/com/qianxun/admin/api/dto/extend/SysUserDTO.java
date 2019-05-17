package com.qianxun.admin.api.dto.extend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qianxun.admin.api.entity.SysUser;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/5/17 14:07
 */
@Data
public class SysUserDTO extends SysUser implements Serializable {
    /**
     * 权限列表
     */
    private List<String> permissions;

    /**
     * 角色列表
     */
    private List<Integer> roles;
}
