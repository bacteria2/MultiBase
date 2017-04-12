package com.multi.auth.shiro.service;

import com.google.common.base.Preconditions;
import com.multi.data.relationdb.role.MRole;
import com.multi.data.relationdb.user.MUser;
import com.multi.data.relationdb.user.dao.MUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shepard.xia
 * @date 2017年04月12日
 * @description input useage
 */
@Service
public class PemissionService {

    @Autowired
    MUserMapper userMapper;

    Set<String> getUserRolesById(Long userId){
       MUser user= userMapper.selectUserRolesByUserId(userId);
        Preconditions.checkNotNull(user,"未找到用户id:%s",userId);
       List<MRole> roleList= user.getRoleList();
       Set<String> roleSet=new HashSet<>();
       roleList.forEach(el->roleSet.add(String.valueOf(el.getRole())));
       return roleSet;
    }

    Set<String> getUserPermissionById(Long userId){

    }
}
