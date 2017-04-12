package com.multi.auth.shiro.service;

import com.multi.data.relationdb.role.MRole;

import javax.management.relation.Role;
import javax.xml.ws.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shepard.xia
 * @date 2017年03月30日
 * @description input useage
 */
public interface IRoleService {

    Response insertRole(MRole role,String creator);

    Response updateRoleById(MRole role,String modifier);

    Response deleteRoleById(MRole role,String modifier);

    List<Role> selectAllRow(int page,int number);

    Response insertUserRole();

    Response updateUserRole();

    Set<String> selectRoleByUserId(Long userId);
}
