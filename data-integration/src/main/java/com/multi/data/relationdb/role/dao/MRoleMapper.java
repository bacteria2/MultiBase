package com.multi.data.relationdb.role.dao;

import com.multi.data.relationdb.role.MRole;
import org.apache.ibatis.session.RowBounds;


import java.util.List;

public interface MRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MRole record);

    int insertSelective(MRole record);

    MRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MRole record);

    int updateByPrimaryKey(MRole record);

    MRole selectRoleUsersByRoleId(Long roleId);

    List<MRole> selectAllRole();

    List<MRole> selectAllRole(RowBounds rowBounds);
}