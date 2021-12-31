package com.back.productbackend.db.mapper;

import com.back.productbackend.db.entity.SystemRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色表(SystemRole)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-31 15:58:18
 */
public interface SystemRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SystemRole queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SystemRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param systemRole 实例对象
     * @return 对象列表
     */
    List<SystemRole> queryAll(SystemRole systemRole);

    /**
     * 新增数据
     *
     * @param systemRole 实例对象
     * @return 影响行数
     */
    int insert(SystemRole systemRole);

    /**
     * 修改数据
     *
     * @param systemRole 实例对象
     * @return 影响行数
     */
    int update(SystemRole systemRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}