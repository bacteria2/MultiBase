package com.multi.data.reletiondb.role.dao;

import com.multi.data.reletiondb.role.MRoleResource;

public interface MRoleResourceMapper {
    int insert(MRoleResource record);

    int insertSelective(MRoleResource record);
}