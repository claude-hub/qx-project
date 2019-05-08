package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.user.consumer.grpc.client.GrpcSysLangClient;
import com.qianxun.user.consumer.model.sysLang.request.SysLangAddInputDTO;
import com.qianxun.user.consumer.utils.mapper.BeanMapper;
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
    public SysLang getLangId(@Valid @PathVariable("id") int id) {
        return grpcSysLangClient.getLangById(id);
    }

    @GetMapping(value = "/list")
    public List<SysLang> getLangList() {
        return grpcSysLangClient.getLangList();
    }

    @PostMapping(value = "/add")
    public boolean addLang(SysLangAddInputDTO inputDTO) {
        SysLang sysLang = BeanMapper.map(inputDTO, SysLang.class);
        return grpcSysLangClient.addLang(sysLang);
    }
}
