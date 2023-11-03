package com.atguigu.mapper;

import com.atguigu.pojo.User;

import java.util.List;

public interface UserMapper {

    //插入
    int insert(User user);
    //修改
    int update(User user);
    //删除
    int delete(Integer id);
    //根据id查询
    User selectById(Integer id);
    //查询所有
    List<User> selectAll();
}
