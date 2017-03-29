package com.multi.test.data.dao;

import com.github.pagehelper.PageRowBounds;

import com.multi.data.dao.UPermissionMapper;
import com.multi.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shepard.xia
 * @date 2017年03月27日
 * @description input useage
 */
public class UPermissionMapperTest extends BaseTest {

    @Autowired
    UPermissionMapper permissionMapper;


    @Test
    public void permissionTest(){
        permissionMapper.selectAll(new PageRowBounds(3,5)).forEach(
                el-> System.out.println(el.getId())
        );

    }

}