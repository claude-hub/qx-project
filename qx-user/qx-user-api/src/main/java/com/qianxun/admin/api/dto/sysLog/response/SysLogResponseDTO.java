package com.qianxun.admin.api.dto.sysLog.response;


import com.qianxun.admin.api.entity.SysLog;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cloudy
 * Date 2019-05-13 15:37:01
 */
@Data
public class SysLogResponseDTO implements Serializable {
    /**
     * 总记录数
     * 需要加上默认为0，避免传回前端连字段都没有
     */
    private Integer total = 0;

    /**
     * 分页查询结果
     * 需初始化，避免传回前端无字段
     */
    private List<SysLog> sysLogs = new ArrayList<>();
}
