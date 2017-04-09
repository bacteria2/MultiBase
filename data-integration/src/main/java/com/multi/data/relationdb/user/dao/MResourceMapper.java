package com.multi.data.relationdb.user.dao;

import com.multi.data.relationdb.user.MResource;
import org.apache.ibatis.session.RowBounds;


import java.util.List;

public interface MResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MResource record);

    int insertSelective(MResource record);

    MResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MResource record);

    int updateByPrimaryKey(MResource record);

    List<MResource> selectAllResource();

    List<MResource> selectAllResource(RowBounds rowBounds);

    List<MResource> selectResourcesByType(int type);

    List<MResource> selectResourcesByRoleId(Long id);
}