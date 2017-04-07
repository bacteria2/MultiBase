package com.multi.data.reletiondb.role.dao;

import com.multi.data.reletiondb.role.MRole;

public interface MRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MRole record);

    int insertSelective(MRole record);

    MRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MRole record);

    int updateByPrimaryKey(MRole record);
}