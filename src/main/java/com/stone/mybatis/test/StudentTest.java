package com.stone.mybatis.test;

import com.stone.mybatis.mapper.StudentDao;
import com.stone.mybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class StudentTest
{

    StudentDao mapper = null;
    Reader reader = null;
    SqlSessionFactory sessionFactory =null;
    //  在每一次单元测试之前执行 （得到操作数据库对象）
    @Before
    public void bef() throws IOException
    {
        //  1.  加载mybatis配置文件
        String resource = "mybatis-config.xml";
        reader = Resources.getResourceAsReader(resource);
        //  2.获取sqlsessionfactory
         sessionFactory = new SqlSessionFactoryBuilder().build(reader);


    }

    //    在每一次测试方法执行之后 （关闭操作数据库需要释放的资源）
    @After
    public void aft()
    {
        if (reader != null)
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }



    }

    //  测试：根据id查询单个学生
    @Test
    public void test1()
    {

        //  3.获取session
          SqlSession sqlSession = sessionFactory.openSession();
        //  4.得到dao的接口
        mapper = sqlSession.getMapper(StudentDao.class);

        Student student = mapper.selectOne(1);
        System.out.println(student);

    }

    //  测试：查询所有学生
    @Test
    public void test2()
    {
        //  3.获取session
        SqlSession sqlSession = sessionFactory.openSession();
        //  4.得到dao的接口
        mapper = sqlSession.getMapper(StudentDao.class);


        List<Student> student = mapper.selectAll();
        System.out.println(student);

    }

    //  测试：添加学生
    @Test
    public void test3()
    {
        //  3.获取session
        SqlSession sqlSession = sessionFactory.openSession();
        //  4.得到dao的接口
        mapper = sqlSession.getMapper(StudentDao.class);

        //  设置需要添加的数据
        Student student =new Student();
        student.setName("xiaoqi");
        student.setAge(27);
        student.setSex("女");
        //  添加学生
        mapper.addStudent(student);
        System.out.println(student);
        //  提交事务 ，要不然无法添加
        sqlSession.commit();

        //  添加完之后查询所有学生
        test2();

    }

    //  测试：根据id修改学生
    @Test
    public void test4()
    {

        //  3.获取session
        SqlSession sqlSession = sessionFactory.openSession();
        //  4.得到dao的接口
        mapper = sqlSession.getMapper(StudentDao.class);

        //  吧学号为一的zs同学修改为zxs同学
        Student student =new Student();
        student.setName("zxs");
        student.setId(1);
        mapper.updStudent(student);
        //  事务提交
        sqlSession.commit();

        //  修改完之后查询所有学生
        test2();
    }

    //  根据学号删除学生
    @Test
    public void test5(){

        //  3.获取session
        SqlSession sqlSession = sessionFactory.openSession();
        //  4.得到dao的接口
        mapper = sqlSession.getMapper(StudentDao.class);

        //  删除学号为2的ls同学
        mapper.delStudent(2);
        //  事务提交
        sqlSession.commit();

        //  删除完之后查询所有学生
        test2();
    }
}
