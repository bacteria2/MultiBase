package com.multi.test.data.dao;

import com.alibaba.fastjson.JSON;
import com.multi.data.relationdb.user.MResource;
import com.multi.data.relationdb.user.dao.MResourceMapper;
import com.multi.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author IonCannon
 * @date 2017/4/9
 * @decription : content
 */
public class ResourceMapperTest  extends BaseTest{
    @Autowired
    MResourceMapper resourceMapper;

    @Test
    public void testInsertResource(){
        MResource resource=new MResource();
        resource.setName("test");
        resource.setPermission("15");
        resource.setResource("/user/login");
        resourceMapper.insertSelective(resource);
    }

    @Test
    public void testSelectResource(){
        System.out.println(JSON.toJSONString(resourceMapper.selectResourcesByType(1)) );
        ; System.out.println(JSON.toJSONString(resourceMapper.selectResourcesByRoleId(1L)) );
        System.out.println(JSON.toJSONString(resourceMapper.selectResourcesByType(3)) );
    }
}
