package com.multi.auth.shiro.service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shepard.xia
 * @date 2017年03月30日
 * @description input useage
 */
public interface IRoleService {
    default Set<String> findRoleByUserId(Long userId){
        Set<String> set=new HashSet<>();
        set.add("888888");
        set.add("100003");
        return set;
    }
}
