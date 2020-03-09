package com.stone.mybatis.model;

import org.apache.ibatis.type.Alias;

@Alias("stu")
public class Student
{
    private Integer id; //  学生学号
    private String name; //  学生姓名
    private Integer age; //  学生年龄
    private String  sex; //  学生性别

    public Student()
    {
    }

    public Student(Integer id, String name, Integer age, String sex)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
