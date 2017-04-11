package com.multi.data.relationdb.user.dao;

import com.multi.data.relationdb.user.MUser;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MUserMapper {

    int deleteById(Long id);

    int insertSelective(MUser record);

    int batchInsertUserRole(Long userId,Long... roleId);

    MUser selectByPrimaryKey(Long id);

    MUser selectUserByUserName(String userName);

    MUser selectUserRolesByUserId(Long id);

    int updateByPrimaryKeySelective(MUser record);

    List<MUser>  selectAllUser();

    List<MUser>  selectAllUser(RowBounds rowBounds);

    List<MUser> userExistCheck(MUser user);

}