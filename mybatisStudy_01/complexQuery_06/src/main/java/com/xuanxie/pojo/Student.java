package com.xuanxie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//多对一  的学生对象
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String name;
    Teacher myTeacher;
}
