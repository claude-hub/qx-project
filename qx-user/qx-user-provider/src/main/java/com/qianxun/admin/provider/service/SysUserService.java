package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.entity.SysUser;

/**
 * @author Cloudy
 *  */
public interface SysUserService extends IService<SysUser> {
    SysUserDTO getUserInfoByAccount(String account);
}
