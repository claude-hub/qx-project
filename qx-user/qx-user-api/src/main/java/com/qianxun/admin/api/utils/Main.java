package com.qianxun.admin.api.utils;

import com.qianxun.admin.api.dto.sysRole.response.SysRoleResponseDTO;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.grpc.lib.sysLang.SysLangOuterClass;
import com.qianxun.grpc.lib.sysRole.SysRoleOuterClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/09/19 14:18
 */
public class Main {
    public static void main(String[] arg){
        SysRoleResponseDTO roleResponseDTO = new SysRoleResponseDTO();
        roleResponseDTO.setTotal(20);
        List<SysRole> sysRoleList = new ArrayList<>();
        SysRole sysRole = new SysRole();
        sysRole.setId(1);
        sysRole.setCreatedAt(new Date());
        sysRole.setUpdatedAt(new Date());
        sysRole.setRoleCode("user");
        sysRole.setStatus(1);
        sysRole.setDbSource("qx");
        sysRoleList.add(sysRole);

        SysRole sysRole1 = new SysRole();
        sysRole1.setId(2);
        sysRole1.setCreatedAt(new Date());
        sysRole1.setUpdatedAt(new Date());
        sysRole1.setRoleCode("user2");
        sysRole1.setStatus(1);
        sysRole1.setDbSource("qx2");
        sysRoleList.add(sysRole1);
        roleResponseDTO.setSysRole(sysRoleList);
        System.out.println(roleResponseDTO);
        SysRoleOuterClass.PageList ad = ProtoBufUtils.toProtoBuffer(roleResponseDTO, SysRoleOuterClass.PageList.class);
        System.out.println("11111111");
        System.out.println(ad);

        SysRoleOuterClass.SysRole a = ProtoBufUtils.toProtoBuffer(sysRole, SysRoleOuterClass.SysRole.class);
        System.out.println("2222222222");
        System.out.println(a);
        System.out.println("33333333333");
        System.out.println(ProtoBufUtils.fromProtoBuffer(sysRole, SysRole.class));

        SysRoleOuterClass.PageList pageList = SysRoleOuterClass.PageList.newBuilder().setTotal(2)
                .addSysRole(SysRoleOuterClass.SysRole.newBuilder().setId(10)
                        .setDbSource("1x").build())
                .build();
        SysRoleResponseDTO responseDTO = ProtoBufUtils.fromProtoBuffer(pageList, SysRoleResponseDTO.class);
        System.out.println(responseDTO);
//        responseDTO.setSysRole();

//        List<SysRole> sysRoles = new ArrayList<>();
//        sysRoles.add()
    }
}
