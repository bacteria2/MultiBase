package com.multi.data.relationdb.user.dao;

import com.multi.data.relationdb.ILogicalDel;
import com.multi.data.relationdb.user.MUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MUserMapper extends ILogicalDel{

    int deleteById(Long id);

    int insertSelective(MUser record);

    int batchInsertUserRole(Long userId,Long... roleId);

    MUser selectByPrimaryKey(Long id);

    MUser selectUserByUserName(String userName);

    MUser selectUserRolesByUserId(Long id);

    int updateByPrimaryKeySelective(MUser record);

    List<MUser>  selectAllUser();

    List<MUser>  selectAllUser(RowBounds rowBounds);

    List<MUser>  userExistCheck(MUser user);

    int addUserRoles(@Param("userId") Long roleId, @Param("creator")String creator, @Param("roleIds")Long... userIds);

}