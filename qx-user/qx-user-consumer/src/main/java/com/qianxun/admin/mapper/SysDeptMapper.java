package com.qianxun.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianxun.admin.api.entity.SysDept;

import java.util.List;

public interface SysDeptMapper extends BaseMapper<SysDept> {

	/**
	 * 关联dept——relation
	 *
	 * @return 数据列表
	 */
	List<SysDept> listDepts();
}
