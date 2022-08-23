package com.xuanxie.dao;

import com.xuanxie.pojotwo.Teacher;

import java.util.List;

public interface TeacherMapperTwo {
    List<Teacher> getTeachers(int tid);
    List<Teacher> getTeachers2(int tid);

}
