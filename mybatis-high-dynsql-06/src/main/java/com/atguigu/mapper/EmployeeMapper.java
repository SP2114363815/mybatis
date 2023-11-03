package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    //根据员工姓名和工资查询员工信息
    List<Employee> query(@Param("name") String name,@Param("salary") Double salary);
    //根据员工id更新员工的数据，我们要求传入的name和salary不为null才更新
    int update(Employee employee);

    //根据id批量查询
    List<Employee>queryBatch(@Param("ids") List<Integer> ids);
    //根据id批量删除
    int deleteBatch(@Param("ids")List<Integer> ids);
    //根据id批量添加
    int insertBatch(@Param("employeeList")List<Employee> employeeList);
    //根据id批量修改
    int updateBatch(@Param("employeeList") List<Employee> employeeList);
}
