package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.base.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.sysLang.request.SysLangAddInputDTO;
import com.qianxun.admin.api.dto.sysLang.request.SysLangDeleteInputDTO;
import com.qianxun.admin.api.dto.sysLang.request.SysLangQueryInputDTO;
import com.qianxun.admin.api.dto.sysLang.request.SysLangUpdateInputDTO;
import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.grpc.lib.sysLang.SysLangOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysLangClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Cloudy
 * Date: 2019/5/7 22:12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/sysLang")
public class SysLangController {
    private final GrpcSysLangClient grpcSysLangClient;

    @GetMapping(value = "/{id}")
    public JSONResult getLangId(@Valid SearchByIdInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysLangOuterClass.ByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(inputDTO, SysLangOuterClass.ByIdReq.class);
        SysLang sysLang = grpcSysLangClient.getLangById(getByIdReq);
        result.setData(sysLang.getId() != null ? sysLang : "");
        return result;
    }

    @GetMapping(value = "/list")
    public JSONResult getLangList(@Valid SysLangQueryInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysLangOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(inputDTO, SysLangOuterClass.GetListReq.class);
        result.setData(grpcSysLangClient.getLangList(getListReq));
        return result;
    }

    @PostMapping(value = "/add")
    public JSONResult addLang(@Valid SysLangAddInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysLangOuterClass.SysLang sysLang = ProtoBufUtils.toProtoBuffer(inputDTO, SysLangOuterClass.SysLang.class);
        result.setData(grpcSysLangClient.addLang(sysLang));
        return result;
    }

    @PutMapping(value = "/update")
    public JSONResult updateLang(@Valid SysLangUpdateInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysLangOuterClass.SysLang sysLang = ProtoBufUtils.toProtoBuffer(inputDTO, SysLangOuterClass.SysLang.class);
        result.setData(grpcSysLangClient.updateLang(sysLang));
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public JSONResult deleteLang(@Valid SysLangDeleteInputDTO inputDTO) {
        JSONResult result = new JSONResult();
        SysLangOuterClass.ByIdReq req = ProtoBufUtils.toProtoBuffer(inputDTO, SysLangOuterClass.ByIdReq.class);
        result.setData(grpcSysLangClient.deleteLang(req));
        return result;
    }
}
