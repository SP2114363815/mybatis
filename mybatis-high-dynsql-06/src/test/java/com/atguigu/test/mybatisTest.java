package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    private SqlSession session;
    @BeforeEach
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        session=sqlSessionFactory.openSession(true);
    }
    @Test

    //if where
    public  void  test(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list=mapper.query(null,100.0);
        System.out.println("list"+list);
    }
    @AfterEach
    public void clean() {
        session.close();

    }



}
