package com.qianxun.admin.api.dto.authUser;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/5/17 12:52
 */
@Data
public class AuthUserResponseDTO implements Serializable {
    private List<String> permissions;
    private List<Integer> roles;
    private Integer deptId;
    private Integer id;
    private String passwordEncrypted;
    private Integer locked;
}
