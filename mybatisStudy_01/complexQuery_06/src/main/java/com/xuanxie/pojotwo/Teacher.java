package com.xuanxie.pojotwo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//多对一
public class Teacher {
    int id;
    String name;
    private List<com.xuanxie.pojotwo.Student> studentList;
}
