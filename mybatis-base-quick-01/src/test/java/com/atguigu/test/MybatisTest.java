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
     * mybatis�ṩ��api���з����ĵ���
     */
    @Test
    public void test_01(){
        //��ȡ�ⲿ�����ļ� mybatis-config.xml
        InputStream ips = null;
        try {
            ips = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //����sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //����sqlSessionFactory����sqlSession(ÿ��ҵ�񴴽�һ���������ͷ�)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //��ȡ�ӿڵĴ�����󣨴����������ô������ķ������ͻ����mapper�ӿڵķ���
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee"+employee);
        //�ύ���񣨷�DQL�����ͷ���Դ
        sqlSession.close();
    }
    //ʹ��ideasis��ʽ
    @Test
    public void test_02(){
        //1,��ȡ�ⲿ�����ļ� mybatis-config.xml
        InputStream ips = null;
        try {
            ips = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //2,����sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //3����sqlSessionFactory����sqlSession(ÿ��ҵ�񴴽�һ���������ͷ�)
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //4,��ȡ�ӿڵĴ�����󣨴����������ô������ķ������ͻ����mapper�ӿڵķ���
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        Employee employee = mapper.queryById(1);
//        System.out.println("employee"+employee);
        //4,sqlSession�ṩ��crud�����������ݿ��ѯ����
        //   ����1���ַ��� sql��ǩ�ı�ʶ,��namespace.id  ����2��ִ��sql��䴫��Ĳ���
        Student student = sqlSession.selectOne("xx.jj.kkk", 1);
        System.out.println("student"+student);
        //5,�ύ���񣨷�DQL�����ͷ���Դ
        sqlSession.commit();
        sqlSession.close();
    }
}
