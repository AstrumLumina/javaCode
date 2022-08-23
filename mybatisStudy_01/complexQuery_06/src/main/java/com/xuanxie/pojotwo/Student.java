package com.xuanxie.pojotwo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//一对多的 学生对象
public class Student {
    int id;
    String name;
    int tid;
}
