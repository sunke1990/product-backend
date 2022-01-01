package com.back.productbackend.db.mapper;

import com.back.productbackend.db.entity.SystemUserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SystemUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-01 22:27:53
 */
public interface SystemUserRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SystemUserRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SystemUserRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param systemUserRole 实例对象
     * @return 对象列表
     */
    List<SystemUserRole> queryAll(SystemUserRole systemUserRole);

    /**
     * 新增数据
     *
     * @param systemUserRole 实例对象
     * @return 影响行数
     */
    int insert(SystemUserRole systemUserRole);

    /**
     * 修改数据
     *
     * @param systemUserRole 实例对象
     * @return 影响行数
     */
    int update(SystemUserRole systemUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}