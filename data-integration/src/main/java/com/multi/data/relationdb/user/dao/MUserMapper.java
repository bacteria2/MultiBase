package com.multi.data.relationdb.user.dao;

import com.multi.data.relationdb.user.MUser;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MUser record);

    int insertSelective(MUser record);

    MUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MUser record);

    int updateByPrimaryKey(MUser record);

    MUser selectUserRolesByUserId(Long id);

    List<MUser>  selectAllUser();

    List<MUser>  selectAllUser(RowBounds rowBounds);
}