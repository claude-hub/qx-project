package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.user.consumer.grpc.client.GrpcSysLangClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
