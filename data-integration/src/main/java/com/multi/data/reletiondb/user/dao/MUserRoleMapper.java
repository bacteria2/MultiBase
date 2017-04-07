package com.multi.data.reletiondb.user.dao;

import com.multi.data.reletiondb.user.model.MUserRole;

public interface MUserRoleMapper {
    int insert(MUserRole record);

    int insertSelective(MUserRole record);
}