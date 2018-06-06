package com.qianxun.service;
import com.qianxun.entity.DBTableEntity;

import java.util.List;

public interface IGeneratorService {
    /**
     * 获取数据库表
     * @return
     */
    List<DBTableEntity> getTables();

    byte[] generatorCode(String[] tableNames);
}