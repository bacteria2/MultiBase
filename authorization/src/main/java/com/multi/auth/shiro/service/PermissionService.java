package com.multi.auth.shiro.service;

import com.multi.data.dao.UPermissionMapper;
import com.multi.data.dao.URoleMapper;
import com.multi.data.dao.UUserMapper;
import com.multi.data.model.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
@Service
public class PermissionService {
    @Autowired
    URoleMapper roleMapper;
    @Autowired
    UPermissionMapper permissionMapper;
    @Autowired
    UUserMapper userMapper;






}
