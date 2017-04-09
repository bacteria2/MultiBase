package com.multi.data.relationdb.organization.dao;

import com.multi.data.relationdb.organization.MOrganization;

public interface MOrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MOrganization record);

    int insertSelective(MOrganization record);

    MOrganization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MOrganization record);

    int updateByPrimaryKey(MOrganization record);
}