package com.multi.data.reletiondb.user.dao;

import com.multi.data.reletiondb.user.model.MUser;

public interface MUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MUser record);

    int insertSelective(MUser record);

    MUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MUser record);

    int updateByPrimaryKey(MUser record);
}