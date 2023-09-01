package com.stone.mybatis.mapper;

import com.stone.mybatis.model.Student;
ii
import java.util.List;
import java.util.Map;

public interface StudentDao
{
    //  根据学号查询单个学生
    Student selectOne(Integer id);

    //  查询所有学生
    List<Student> selectAll();

    //  添加学生
    void addStudent(Student student);

    //  修改学生
    void updStudent(Student student);

    //  删除学生
    void delStudent(Integer id);

    //  多条件查询学生
//    Student  selectOne2( @Param("id") Integer id, @Param("name") String name);
//    Student  selectOne2(Student student);
    //  添加测试代码提交
    Student  selectOne2(Map map);

}
