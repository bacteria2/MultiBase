package com.multi.data.reletiondb.organization.dao;

import com.multi.data.reletiondb.user.model.MOrganization;

public interface MOrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MOrganization record);

    int insertSelective(MOrganization record);

    MOrganization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MOrganization record);

    int updateByPrimaryKey(MOrganization record);
}