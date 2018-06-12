package com.qianxun.admin.dto.sysRole.request;

import java.util.Date;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 角色表
 *
 * @author cloudy
 * @date 2018-06-12 22:31:11
 */
public class SysRoleUpdateInputDTO {

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @NotBlank(message = "角色名不能为空")
    @ApiModelProperty(value = "角色名" , required = true)

    private String name;
    @ApiModelProperty(value = "描述")

    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}