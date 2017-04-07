package com.multi.data.reletiondb.user.dao;

import com.multi.data.reletiondb.user.model.MResource;

public interface MResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MResource record);

    int insertSelective(MResource record);

    MResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MResource record);

    int updateByPrimaryKey(MResource record);
}