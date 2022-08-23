package com.xuanxie.daoTest;

import com.xuanxie.dao.StudentMapper;
import com.xuanxie.dao.TeacherMapper;
import com.xuanxie.dao.TeacherMapperTwo;

import com.xuanxie.pojo.Student;
import com.xuanxie.pojo.Teacher;
import com.xuanxie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTeacherTest {

    //多对一测试
    @Test
    public void getTeacherById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherById = mapper.getTeacherById(1);
        System.out.println(teacherById);
    }

    @Test
    public void getAllStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.getAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }


        System.out.println("方式二:********************");
        System.out.println(allStudent);
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }

    //一对多查询
    @Test
    public void getTeachers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapperTwo mapper = sqlSession.getMapper(TeacherMapperTwo.class);
        List<com.xuanxie.pojotwo.Teacher> teachers = mapper.getTeachers(1);
        for (com.xuanxie.pojotwo.Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
    @Test
    public void getTeachers2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapperTwo mapper = sqlSession.getMapper(TeacherMapperTwo.class);
        List<com.xuanxie.pojotwo.Teacher> teachers = mapper.getTeachers2(1);
        for (com.xuanxie.pojotwo.Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
