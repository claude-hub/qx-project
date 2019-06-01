package com.qianxun.admin.provider.grpc.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserAddInputDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserQueryInputDTO;
import com.qianxun.admin.api.dto.sysUser.response.SysUserResponseDTO;
import com.qianxun.admin.api.entity.SysUser;
import com.qianxun.admin.api.entity.SysUserMenu;
import com.qianxun.admin.api.entity.SysUserRole;
import com.qianxun.admin.provider.service.SysUserMenuService;
import com.qianxun.admin.provider.service.SysUserRoleService;
import com.qianxun.admin.provider.service.SysUserService;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysUser.SysUserOuterClass;
import com.qianxun.grpc.lib.sysUser.SysUserServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cloudy
 */
@GrpcService(SysUserOuterClass.class)
@AllArgsConstructor
public class GrpcSysUserService extends SysUserServiceGrpc.SysUserServiceImplBase {
    private final SysUserService sysUserService;
    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();
    private final SysUserMenuService sysUserMenuService;
    private final SysUserRoleService sysUserRoleService;

    @Override
    public void getById(SysUserOuterClass.ByIdReq request,
                        StreamObserver<SysUserOuterClass.SysUser> responseObserver) {
        SysUser sysUser = sysUserService.getById(request.getId());
        SysUserOuterClass.SysUser res = ProtoBufUtils.toProtoBuffer(sysUser, SysUserOuterClass.SysUser.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void getList(SysUserOuterClass.GetListReq request,
                        StreamObserver<SysUserOuterClass.PageList> responseObserver) {
        SysUserQueryInputDTO inputDTO = ProtoBufUtils.fromProtoBuffer(request, SysUserQueryInputDTO.class);
        IPage<SysUser> page = new Page<SysUser>(inputDTO.getPage(), inputDTO.getPageSize());
        IPage pageList;
        if (inputDTO.getQuery() == null || inputDTO.getQuery().equals("")) {
            pageList = sysUserService.page(page, Wrappers.<SysUser>query().lambda().orderByDesc(SysUser::getCreatedAt));
        } else {
            pageList = sysUserService.page(page, Wrappers.<SysUser>query().lambda()
                    .and(item -> item
                            .like(SysUser::getDeptId, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getName, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getIdentification, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getPhone, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getEmail, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getAvatar, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getLocked, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getDeleted, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getUserName, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getResetPasswordToken, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getPasswordEncrypted, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getCreatedAt, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getUpdatedAt, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getCurrentToken, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getCurrentSignInAt, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getLastSignInAt, inputDTO.getQuery())
                            .or()
                            .like(SysUser::getSignInCount, inputDTO.getQuery())
                    )
                    .orderByDesc(SysUser::getCreatedAt)

            );
        }
        SysUserResponseDTO dto = new SysUserResponseDTO();
        dto.setTotal((int) pageList.getTotal());
        dto.setSysUsers(pageList.getRecords());
        SysUserOuterClass.PageList res = ProtoBufUtils.toProtoBuffer(dto, SysUserOuterClass.PageList.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    @SneakyThrows
    @Transactional
    public void insert(SysUserOuterClass.BaseSysUser request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        SysUserAddInputDTO addInputDTO = ProtoBufUtils.fromProtoBuffer(request, SysUserAddInputDTO.class);
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(addInputDTO, sysUser);
        if(sysUserService.getOne(Wrappers.<SysUser>query().lambda()
                .eq(SysUser::getPhone, addInputDTO.getPhone()))!=null){
            responseDTO.setSuccess(false);
            responseDTO.setMessage("手机号已存在");
        }else {
            if(sysUserService.getOne(Wrappers.<SysUser>query().lambda()
                    .eq(SysUser::getUserName, addInputDTO.getUserName()))!=null) {
                responseDTO.setSuccess(false);
                responseDTO.setMessage("用户名已存在");
            }else {
                if(sysUserService.getOne(Wrappers.<SysUser>query().lambda()
                        .eq(SysUser::getEmail, addInputDTO.getEmail()))!=null) {
                    responseDTO.setSuccess(false);
                    responseDTO.setMessage("邮箱已存在");
                }else {
                    sysUserService.save(sysUser);
                    List<SysUserRole> roles = new ArrayList<>();
                    for (Integer roleId:
                    addInputDTO.getRoleIds()) {
                        SysUserRole role = new SysUserRole();
                        role.setUserId(sysUser.getId());
                        role.setRoleId(roleId);
                        roles.add(role);
                    }
                    sysUserRoleService.saveBatch(roles);

                    List<SysUserMenu> menus = new ArrayList<>();
                    for (Integer menuId:
                         addInputDTO.getPermissionIds()) {
                        SysUserMenu sysUserMenu = new SysUserMenu();
                        sysUserMenu.setMenuId(menuId);
                        sysUserMenu.setUserId(sysUser.getId());
                        menus.add(sysUserMenu);
                    }
                    sysUserMenuService.saveBatch(menus);
                    responseDTO.setSuccess(true);
                }
            }
        }
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void update(SysUserOuterClass.SysUser request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        SysUser sysUser = ProtoBufUtils.fromProtoBuffer(request, SysUser.class);
        responseDTO.setSuccess(sysUserService.updateById(sysUser));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysUserOuterClass.ByIdReq request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        responseDTO.setSuccess(sysUserService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }
}
