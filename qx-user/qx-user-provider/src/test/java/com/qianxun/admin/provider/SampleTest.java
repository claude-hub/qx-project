package com.qianxun.admin.provider;

import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.admin.provider.service.SysDeptService;
import com.qianxun.admin.provider.service.SysMenuService;
import com.qianxun.admin.provider.service.SysRoleService;
import com.qianxun.admin.provider.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/10/19 16:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SampleTest {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void testSelect() {
       SysUserDTO sysUserDTO = sysUserService.getUserInfoByAccount("15223246130");
       System.out.println(sysUserDTO);

       List<SysMenuDTO> menuDTOS = sysMenuService.getUserMenusWithLang(1,1);

        menuDTOS.forEach(System.out::println);



        SysRole sysRole = new SysRole();
        sysRole.setId(3);
//        sysRole.setUpdatedAt(new Date());
        sysRole.setRoleCode("aseaw");
//        sysRole.setVersion(0);
        if(sysRoleService.updateById(sysRole)){
            System.out.println("Update successfully");
        }else{
            System.out.println("Update failed due to modified by others");
        }
//        sysRoleService.removeById(9);

        System.out.println(("----- selectAll method test ------"));
        List<SysRole> userList = sysRoleService.list();
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
