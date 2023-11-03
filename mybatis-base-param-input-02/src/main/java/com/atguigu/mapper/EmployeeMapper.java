package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //根据id查询员工对象
    Employee queryById(Integer id);
    //根据id删除员工信息
    int deleteById(Integer id);
    //根据工资查询员工信息
    List<Employee> queryBySalary(Double salary);
    //插入员工数据（实体对象）
    int insertEmp(Employee employee);
    //根据员工姓名和工资查询信息
    List<Employee> queryByNameAndSalary(@Param("a") String name, @Param("b") Double salary);
    //插入员工数据，纯入的是一个map(name=员工的名字，salary=员工的薪水)
    //mapper接口中不允许重载
    int insertEmpMap(Map data);

}
