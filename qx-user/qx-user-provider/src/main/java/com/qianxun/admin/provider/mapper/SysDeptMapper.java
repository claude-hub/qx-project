package com.qianxun.admin.provider.mapper;

import com.qianxun.admin.api.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cloudy
 * @date 2019-04-27 14:07:32
 */
@Mapper
public interface SysDeptMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysDept record);

    SysDept selectByPrimaryKey(Integer id);

    List<SysDept> selectAll();

    int updateByPrimaryKey(SysDept record);

}
