package com.atguigu.mapper;

import com.atguigu.pojo.Teacher;

public interface TeacherMapper {
    int insertTeacher(Teacher teacher);

    Teacher queryById(String tId);
}
