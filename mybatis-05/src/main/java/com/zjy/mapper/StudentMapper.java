package com.zjy.mapper;

import com.zjy.pojo.Student;

import java.util.List;

public interface StudentMapper {

    Student getStudent(int id);

    List<Student> getStudentJoin();

    List<Student> getStudents();
}
