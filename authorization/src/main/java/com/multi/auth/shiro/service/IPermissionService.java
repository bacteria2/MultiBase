package com.multi.auth.shiro.service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shepard.xia
 * @date 2017年03月30日
 * @description input useage
 */
public interface IPermissionService {

    default Set<String> findPermissionByUserId(Long id) {
        Set<String> set=new HashSet<>();
        set.add("/index");
        set.add("/");
        return set;
    }
}
