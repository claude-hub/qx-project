//package com.qianxun.admin.provider;
//
//import com.qianxun.admin.api.dto.extend.SysUserDTO;
//import com.qianxun.admin.api.entity.SysRole;
//import com.qianxun.admin.provider.service.SysRoleService;
//import com.qianxun.admin.provider.service.SysUserService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
///**
// * @author Cloudy
// * Date: 2019/5/30 22:49
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class SampleTest {
//
//    @Autowired
//    private SysRoleService sysRoleService;
//
//    @Autowired
//    private SysUserService sysUserService;
//
//    @Test
//    public void testSelect() {
////        log.debug("debug message");
////        log.warn("warn message");
////        log.info("info message");
////        log.error("error message");
////        log.trace("trace message");
////
////        SysRole add = new SysRole();
////        add.setRoleCode("adadsada");
////        sysRoleService.save(add);
////        SysRole sysRole = new SysRole();
////        sysRole.setId(3);
//////        sysRole.setUpdatedAt(new Date());
////        sysRole.setRoleCode("aseaw");
//////        sysRole.setVersion(0);
////        if(sysRoleService.updateById(sysRole)){
////            System.out.println("Update successfully");
////        }else{
////            System.out.println("Update failed due to modified by others");
////        }
//////        sysRoleService.removeById(9);
////
////        System.out.println(("----- selectAll method test ------"));
////        List<SysRole> userList = sysRoleService.list();
//////        Assert.assertEquals(5, userList.size());
////        userList.forEach(System.out::println);
//        SysUserDTO  sysUserDTO = sysUserService.signIn("15223246130", "123456");
//
//        System.out.println(sysUserDTO);
//    }
//
//}
