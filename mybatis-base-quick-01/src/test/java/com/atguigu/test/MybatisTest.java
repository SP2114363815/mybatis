package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    /**
     * mybatis提供的api进行方法的调用
     */
    @Test
    public void test_01(){
        //读取外部配置文件 mybatis-config.xml
        InputStream ips = null;
        try {
            ips = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //根据sqlSessionFactory创建sqlSession(每次业务创建一个，用完释放)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取接口的代理对象（代理技术）调用代理对象的方法，就会查找mapper接口的方法
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee"+employee);
        //提交事务（非DQL）和释放资源
        sqlSession.close();
    }
    //使用ideasis方式
    @Test
    public void test_02(){
        //1,读取外部配置文件 mybatis-config.xml
        InputStream ips = null;
        try {
            ips = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //2,创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //3根据sqlSessionFactory创建sqlSession(每次业务创建一个，用完释放)
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //4,获取接口的代理对象（代理技术）调用代理对象的方法，就会查找mapper接口的方法
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        Employee employee = mapper.queryById(1);
//        System.out.println("employee"+employee);
        //4,sqlSession提供的crud方法进行数据库查询即可
        //   参数1：字符串 sql标签的标识,：namespace.id  参数2：执行sql语句传入的参数
        Student student = sqlSession.selectOne("xx.jj.kkk", 1);
        System.out.println("student"+student);
        //5,提交事务（非DQL）和释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}
