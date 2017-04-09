package com.multi.test.data.dao;

import com.multi.data.relationdb.role.MRole;
import com.multi.data.relationdb.role.dao.MRoleMapper;
import com.multi.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author IonCannon
 * @date 2017/4/9
 * @decription : content
 */
public class RoleMapperTest  extends BaseTest{
    @Autowired
    MRoleMapper roleMapper;

    @Test
    public void testInsert(){
        MRole role=new MRole();
        role.setName("role1");
        role.setRole(15);

        roleMapper.insertSelective(role);

    }
}
