package com.multi.auth.shiro.service;

import com.google.common.base.Preconditions;
import com.multi.data.relationdb.role.dao.MRoleMapper;
import com.multi.data.relationdb.user.dao.MResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author shepard.xia
 * @date 2017年04月12日
 * @description input useage
 */
@Service
public class PermissionService {
    @Autowired
    MResourceMapper resourceMapper;

    @Autowired
    MRoleMapper roleMapper;


   public Set<String> getUserRolesById(Long userId) {
        Preconditions.checkNotNull(userId, "id不能为空");
        return roleMapper.getRolesByUserId(userId);
    }

    public Set<String> getUserResourceById(Long userId) {
        Preconditions.checkNotNull(userId, "id不能为空");
        return resourceMapper.getResourceByUserId(userId);
    }


}
