package com.qianxun.admin.api.dto.sysOrder.response;

import com.qianxun.admin.api.entity.SysOrder;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cloudy
 *  */
@Data
public class SysOrderResponseDTO implements Serializable {
    /**
     * 总记录数
     * 需要加上默认为0，避免传回前端连字段都没有
     */
    private Integer total = 0;

    /**
     * 分页查询结果
     * 需初始化，避免传回前端无字段
     */
    private List<SysOrder> sysOrders = new ArrayList<>();
}
