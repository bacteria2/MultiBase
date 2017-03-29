package com.multi.data.dao;

import com.github.pagehelper.PageRowBounds;
import com.multi.data.model.UPermission;
import com.sun.istack.internal.Nullable;

import java.util.List;

public interface UPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_permission
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_permission
     *
     * @mbg.generated
     */
    int insert(UPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_permission
     *
     * @mbg.generated
     */
    UPermission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_permission
     *
     * @mbg.generated
     */
    List<UPermission> selectAll(@Nullable PageRowBounds pageRowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UPermission record);
}