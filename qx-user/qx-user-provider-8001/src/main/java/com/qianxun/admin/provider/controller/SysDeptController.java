package com.qianxun.admin.provider.controller;

import com.qianxun.admin.provider.model.dto.sysDept.request.*;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.admin.provider.service.SysDeptService;
import com.qianxun.admin.provider.utils.mapper.BeanMapper;
import com.qianxun.admin.provider.utils.result.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 *
 *
 * @author cloudy
 * @date 2019-04-27 14:07:32
 */
@RestController
@RequestMapping("/api/admin/sysDept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysDeptQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysDeptService.findAllSysDepts());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysDeptAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysDept sysDept = BeanMapper.map(input,SysDept.class);
        jsonResult.setData(sysDeptService.addSysDept(sysDept));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysDeptDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysDeptService.deleteSysDept(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysDeptUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysDept sysDept = BeanMapper.map(input,SysDept.class);
        jsonResult.setData(sysDeptService.editSysDept(sysDept));
        return jsonResult;
    }

    @Autowired
	private DiscoveryClient client;
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("QX-USER-PROVIDER");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
