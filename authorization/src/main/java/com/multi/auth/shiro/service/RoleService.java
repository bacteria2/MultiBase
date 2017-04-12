package com.multi.auth.shiro.service;

import com.google.common.base.Preconditions;
import com.multi.auth.shiro.MResponse;
import com.multi.data.relationdb.role.MRole;
import com.multi.data.relationdb.role.dao.MRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shepard.xia
 * @date 2017年04月12日
 * @description input useage
 */
@Service
public class RoleService {

    @Autowired
    MRoleMapper roleMapper;

    MResponse addNewRole(MRole role, String creator){
        Preconditions.checkNotNull(role.getRole());
        if(roleMapper.roleExistCheck(role).size()>0){
            return new MResponse("role已经存在,请修改",2);
        }else {
            roleMapper.insertSelective(role);
            return new MResponse("新增role成功",0);
        }
    }
}
