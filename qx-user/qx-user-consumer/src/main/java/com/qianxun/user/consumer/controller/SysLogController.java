package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.base.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.sysLog.request.*;
import com.qianxun.admin.api.dto.sysLog.response.SysLogResponseDTO;
import com.qianxun.admin.api.entity.SysLog;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysLog.SysLogOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysLogClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author cloudy
 * Date 2019-05-13 17:03:04
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/sysLog")
public class SysLogController {
    private final GrpcSysLogClient grpcSysLogClient;

    /**
     * selectById
     *
     * @param input
     * @return
     */
    @GetMapping(value = "/{id}")
    public JSONResult getSysLogId(@Valid SearchByIdInputDTO input) {
        JSONResult result = new JSONResult();
        SysLogOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(input, SysLogOuterClass.ByIdReq.class);
        SysLog sysLog = grpcSysLogClient.getSysLogById(getByIdReq);
        result.setData(sysLog.getId() != null ? sysLog : "");
        return result;
    }

    /**
     * 根据语言分页查询
     *
     * @param input
     * @return
     */
    @GetMapping(value = "/list")
    public JSONResult getSysLogList(@Valid SysLogQueryInputDTO input) {
        JSONResult result = new JSONResult();
        SysLogOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(input, SysLogOuterClass.GetListReq.class);
        SysLogResponseDTO responseDTO = grpcSysLogClient.getSysLogList(getListReq);
        result.setData(responseDTO.getSysLogs());
        result.setTotalCount(responseDTO.getTotal());
        return result;
    }

    /**
     * 根据语言新增
     *
     * @param input
     * @return
     */
    @PostMapping(value = "/add")
    public JSONResult addSysLog(@Valid SysLogAddInputDTO input) {
        JSONResult result = new JSONResult();
        SysLogOuterClass.BaseSysLog baseSysLog = ProtoBufUtils.toProtoBuffer(input, SysLogOuterClass.BaseSysLog.class);
        result.setData(grpcSysLogClient.addSysLog(baseSysLog));
        return result;
    }

    /**
     * 更新
     *
     * @param input
     * @return
     */
    @PutMapping(value = "/update")
    public JSONResult updateSysLog(@Valid SysLogUpdateInputDTO input) {
        JSONResult result = new JSONResult();
        SysLogOuterClass.SysLog sysLog = ProtoBufUtils.toProtoBuffer(input, SysLogOuterClass.SysLog.class);
        result.setData(grpcSysLogClient.updateSysLog(sysLog));
        return result;
    }

    /**
     * 逻辑删除
     *
     * @param input
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONResult deleteSysLog(@Valid SysLogDeleteInputDTO input) {
        JSONResult result = new JSONResult();
        SysLogOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(input, SysLogOuterClass.ByIdReq.class);
        result.setData(grpcSysLogClient.deleteSysLog(req));
        return result;
    }
}
