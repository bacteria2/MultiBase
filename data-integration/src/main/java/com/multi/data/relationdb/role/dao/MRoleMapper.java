package com.multi.data.relationdb.role.dao;

import com.multi.data.relationdb.ILogicalDel;
import com.multi.data.relationdb.role.MRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;


import java.util.List;

public interface MRoleMapper extends ILogicalDel {


    int insertSelective(MRole record);

    MRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MRole record);


    MRole selectRoleUsersByRoleId(Long roleId);

    List<MRole> selectAllRole();

    List<MRole> selectAllRole(RowBounds rowBounds);

    int batchInsertRoleUser(@Param("roleId") Long roleId,@Param("creator")String creator,@Param("userIds")Long... userIds);

    int batchInsertRoleResources(@Param("roleId")  Long roleId,@Param("creator")String creator,@Param("resourceIds") Long... resourceIds);

    List<MRole> roleExistCheck(MRole role);


}