package com.qianxun.generator.service;

import java.util.List;
import java.util.Map;

public interface GeneratorService {
    /**
     * 获取数据库表
     * @return
     */
    List<Map<String, Object>> getTables();

    byte[] generatorCode(String[] tableNames, List<String> templates);
}
