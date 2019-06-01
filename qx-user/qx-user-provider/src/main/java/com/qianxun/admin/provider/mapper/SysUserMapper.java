package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.extend.SysUserVM;
import com.qianxun.admin.api.dto.sysUser.request.SysUserQueryInputDTO;
import com.qianxun.admin.api.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Cloudy
 *  */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 分页查询用户信息（含角色）
     *
     * @param page    分页
     * @param dto 查询参数
     * @return list
     */
    IPage<List<SysUserVM>> getUserVMsPage(Page page, @Param("query") SysUserQueryInputDTO dto);
}
