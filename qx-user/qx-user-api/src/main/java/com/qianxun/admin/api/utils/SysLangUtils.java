package com.qianxun.admin.api.utils;

import com.google.protobuf.util.Timestamps;
import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.grpc.lib.sysLang.SysLangOuterClass;

import java.util.Date;

/**
 * @author Cloudy
 * Date: 2019/5/7 23:51
 */
public class SysLangUtils {
    public static SysLang grpcMessageToEntity(SysLangOuterClass.SysLang res){
        SysLang sysLang = new SysLang();
        sysLang.setId(res.getId());
        sysLang.setName(res.getName());
        sysLang.setCreatedAt(new Date(res.getCreatedAt().getSeconds()*1000));
        sysLang.setUpdatedAt(new Date(res.getUpdatedAt().getSeconds()*1000));
        sysLang.setStatus(res.getStatus());
        sysLang.setDbSource(res.getDbSource());
        return sysLang;
    }
    public static SysLangOuterClass.SysLang entityToGrpcMessage(SysLang sysLang){
        return SysLangOuterClass.SysLang
                .newBuilder()
                .setId(sysLang.getId())
                .setName(sysLang.getName())
                .setCreatedAt(Timestamps.fromMillis(sysLang.getCreatedAt().getTime()))
                .setUpdatedAt(Timestamps.fromMillis(sysLang.getUpdatedAt().getTime()))
                .setDbSource(sysLang.getDbSource())
                .build();
    }
}
