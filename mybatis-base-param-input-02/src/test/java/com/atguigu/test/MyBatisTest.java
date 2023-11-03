package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.datasource.DataSourceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void test01(){
        //��ȡ�ⲿ�����ļ�
        InputStream ips = null;
        try {
            ips = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //����sqlSessionFactory����
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //��ȡsqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //��ȡ����mapper����
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee= mapper.queryById(1);
        System.out.println("employee"+employee);
        //�ύ������߹ر���Դ
       sqlSession.close();
    }
}
