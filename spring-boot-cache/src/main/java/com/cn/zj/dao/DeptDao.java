package com.cn.zj.dao;

import com.cn.zj.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@Mapper
public interface DeptDao {
//    @Select("select * from dept where id =#{id}")
    Dept findById(int id);

    @Update("update dept set dept_name = #{deptName},dept_no = #{deptNo} where id =#{id}")
    int update(Dept dept);
}
