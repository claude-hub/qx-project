package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.dto.SearchByIdInputDTO;
import com.qianxun.admin.api.dto.sysLang.request.SysLangAddInputDTO;
import com.qianxun.admin.api.dto.sysLang.request.SysLangQueryInputDTO;
import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.admin.api.utils.ProtoBufUtils;
import com.qianxun.grpc.lib.sysLang.SysLangOuterClass;
import com.qianxun.user.consumer.grpc.client.GrpcSysLangClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public SysLang getLangId(@Valid SearchByIdInputDTO inputDTO) {
        SysLangOuterClass.GetByIdReq getByIdReq = ProtoBufUtils.toProtoBuffer(inputDTO, SysLangOuterClass.GetByIdReq.class);
        return grpcSysLangClient.getLangById(getByIdReq);
    }

    @GetMapping(value = "/list")
    public List<SysLang> getLangList(@Valid SysLangQueryInputDTO inputDTO) {
        SysLangOuterClass.GetListReq getListReq = ProtoBufUtils.toProtoBuffer(inputDTO, SysLangOuterClass.GetListReq.class);
        return grpcSysLangClient.getLangList(getListReq);
    }

    @PostMapping(value = "/add")
    public int addLang(@Valid SysLangAddInputDTO inputDTO) {
        SysLangOuterClass.SysLang sysLang = ProtoBufUtils.toProtoBuffer(inputDTO, SysLangOuterClass.SysLang.class);
        return grpcSysLangClient.addLang(sysLang);
    }
}
