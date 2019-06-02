package com.qianxun.admin.provider.grpc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserAddInputDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserQueryInputDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserUpdateInputDTO;
import com.qianxun.admin.api.dto.sysUser.response.SysUserResponseDTO;
import com.qianxun.admin.api.entity.SysUser;
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
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cloudy
 */
@GrpcService(SysUserOuterClass.class)
@AllArgsConstructor
public class GrpcSysUserService extends SysUserServiceGrpc.SysUserServiceImplBase {
    private final SysUserService sysUserService;
//    private final UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();
    private final SysUserMenuService sysUserMenuService;
    private final SysUserRoleService sysUserRoleService;
    private final PasswordEncoder passwordEncoder;

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
        Page<SysUser> page = new Page<SysUser>(inputDTO.getPage(), inputDTO.getPageSize());

        IPage pageList = sysUserService.getUserWithRolePage(page, inputDTO);

        SysUserResponseDTO dto = new SysUserResponseDTO();
        dto.setTotal((int) pageList.getTotal());
        dto.setSysUsers(pageList.getRecords());
        SysUserOuterClass.PageList res = ProtoBufUtils.toProtoBuffer(dto, SysUserOuterClass.PageList.class);
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
//    @SneakyThrows
//    @Transactional
    public void insert(SysUserOuterClass.BaseSysUser request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        SysUserAddInputDTO addInputDTO = ProtoBufUtils.fromProtoBuffer(request, SysUserAddInputDTO.class);
        UpdateDBResponseDTO responseDTO = sysUserService.addUser(addInputDTO);
//        SysUser sysUser = new SysUser();
//        BeanUtil.copyProperties(addInputDTO, sysUser);
//        if (sysUserService.getOne(Wrappers.<SysUser>query().lambda()
//                .eq(SysUser::getPhone, addInputDTO.getPhone())) != null) {
//            responseDTO.setSuccess(false);
//            responseDTO.setMessage("手机号已存在");
//        } else {
//            if (sysUserService.getOne(Wrappers.<SysUser>query().lambda()
//                    .eq(SysUser::getUserName, addInputDTO.getUserName())) != null) {
//                responseDTO.setSuccess(false);
//                responseDTO.setMessage("用户名已存在");
//            } else {
//                if (sysUserService.getOne(Wrappers.<SysUser>query().lambda()
//                        .eq(SysUser::getEmail, addInputDTO.getEmail())) != null) {
//                    responseDTO.setSuccess(false);
//                    responseDTO.setMessage("邮箱已存在");
//                } else {
//                    sysUserService.save(sysUser);
//                    List<SysUserRole> roles = new ArrayList<>();
//                    for (Integer roleId :
//                            addInputDTO.getRoleIds()) {
//                        SysUserRole role = new SysUserRole();
//                        role.setUserId(sysUser.getId());
//                        role.setRoleId(roleId);
//                        roles.add(role);
//                    }
//                    sysUserRoleService.saveBatch(roles);
//
//                    List<SysUserMenu> menus = new ArrayList<>();
//                    for (Integer menuId :
//                            addInputDTO.getPermissionIds()) {
//                        SysUserMenu sysUserMenu = new SysUserMenu();
//                        sysUserMenu.setMenuId(menuId);
//                        sysUserMenu.setUserId(sysUser.getId());
//                        menus.add(sysUserMenu);
//                    }
//                    sysUserMenuService.saveBatch(menus);
//                    responseDTO.setSuccess(true);
//                }
//            }
//        }
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
//    @Transactional
    public void update(SysUserOuterClass.BaseSysUser request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        SysUserUpdateInputDTO dto = ProtoBufUtils.fromProtoBuffer(request, SysUserUpdateInputDTO.class);
        UpdateDBResponseDTO responseDTO = sysUserService.updateUser(dto);
//        SysUser sysUser = new SysUser();
//        BeanUtil.copyProperties(dto, sysUser);
//        sysUser.setPasswordEncrypted(passwordEncoder.encode(sysUser.getPasswordEncrypted()));
//        if(sysUserService.updateById(sysUser)){
//            /**
//             * 保存角色
//             */
//            sysUserRoleService.remove(Wrappers.<SysUserRole>update().lambda()
//                    .eq(SysUserRole::getUserId, dto.getId()));
//            dto.getRoleIds().forEach(roleId -> {
//                SysUserRole userRole = new SysUserRole();
//                userRole.setUserId(sysUser.getId());
//                userRole.setRoleId(roleId);
//                sysUserRoleService.save(userRole);
//            });
//
//            /**
//             * 单独权限
//             */
//            sysUserMenuService.remove(Wrappers.<SysUserMenu>update().lambda()
//                    .eq(SysUserMenu::getUserId, dto.getId()));
//            if (dto.getPermissionIds() != null && dto.getPermissionIds().size() > 0) {
//                dto.getPermissionIds().forEach(menuId -> {
//                    SysUserMenu userMenu = new SysUserMenu();
//                    userMenu.setUserId(sysUser.getId());
//                    userMenu.setMenuId(menuId);
//                    sysUserMenuService.save(userMenu);
//                });
//            }
//            responseDTO.setSuccess(true);
//        }else {
//            responseDTO.setSuccess(false);
//            responseDTO.setMessage("其他人已更新，更新失败!");
//        }
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }

    @Override
    public void delete(SysUserOuterClass.ByIdReq request,
                       StreamObserver<SysUserOuterClass.Result> responseObserver) {
        UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();
        responseDTO.setSuccess(sysUserService.removeById(request.getId()));
        responseObserver.onNext(ProtoBufUtils.toProtoBuffer(responseDTO, SysUserOuterClass.Result.class));
        responseObserver.onCompleted();
    }
}
