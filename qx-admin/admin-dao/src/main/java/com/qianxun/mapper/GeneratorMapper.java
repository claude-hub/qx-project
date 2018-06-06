package com.qianxun.mapper;

import com.qianxun.entity.DBTableEntity;

import java.util.List;
import java.util.Map;

public interface GeneratorMapper {
    List<DBTableEntity> selectAll();

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
