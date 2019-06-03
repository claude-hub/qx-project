package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.base.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.sysOrder.request.*;
import com.qianxun.admin.api.dto.sysOrder.response.SysOrderResponseDTO;
import com.qianxun.admin.api.entity.SysOrder;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysOrderClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author Cloudy
 *  */
@RestController
@AllArgsConstructor
@RequestMapping("/sysOrder")
public class SysOrderController {
    private final GrpcSysOrderClient grpcSysOrderClient;

    /**
    * selectById
    * @param input
    * @return
    */
    @GetMapping(value = "/{id}")
    public JSONResult getSysOrderId(@Valid SearchByIdInputDTO input) {
        JSONResult result = new JSONResult();
        SysOrderOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(input, SysOrderOuterClass.ByIdReq.class);
        SysOrder sysOrder = grpcSysOrderClient.getSysOrderById(getByIdReq);
        result.setData(sysOrder.getId() != null ? sysOrder : "");
        return result;
    }

    /**
    * 根据语言分页查询
    * @param input
    * @return
    */
    @GetMapping(value = "/list")
    public JSONResult getSysOrderList(@Valid SysOrderQueryInputDTO input) {
        JSONResult result = new JSONResult();
        SysOrderOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(input, SysOrderOuterClass.GetListReq.class);
        SysOrderResponseDTO responseDTO = grpcSysOrderClient.getSysOrderList(getListReq);
        result.setData(responseDTO.getSysOrders());
        result.setTotalCount(responseDTO.getTotal());
        return result;
    }

    /**
    * 根据语言新增
    * @param input
    * @return
    */
    @PostMapping(value = "/add")
    public JSONResult addSysOrder(@Valid SysOrderAddInputDTO input) {
        JSONResult result = new JSONResult();
        SysOrderOuterClass.BaseSysOrder baseSysOrder = ProtoBufUtils.toProtoBuffer(input, SysOrderOuterClass.BaseSysOrder.class);
        result.setData(grpcSysOrderClient.addSysOrder(baseSysOrder));
        return result;
    }

    /**
    * 更新
    * @param input
    * @return
    */
    @PutMapping(value = "/update")
    public JSONResult updateSysOrder(@Valid SysOrderUpdateInputDTO input) {
        JSONResult result = new JSONResult();
        SysOrderOuterClass.SysOrder sysOrder = ProtoBufUtils.toProtoBuffer(input, SysOrderOuterClass.SysOrder.class);
        result.setData(grpcSysOrderClient.updateSysOrder(sysOrder));
        return result;
    }

    /**
    * 逻辑删除
    * @param input
    * @return
    */
    @PostMapping(value = "/delete")
    public JSONResult deleteSysOrder(@Valid SysOrderDeleteInputDTO input) {
        JSONResult result = new JSONResult();
        SysOrderOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(input, SysOrderOuterClass.ByIdReq.class);
        result.setData(grpcSysOrderClient.deleteSysOrder(req));
        return result;
    }
}
