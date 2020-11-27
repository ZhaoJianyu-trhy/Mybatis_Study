package com.zjy.mapper;

import com.zjy.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeacher();

    //获取指定老师的的所有信息（包含学生）
    Teacher getTeacherA(@Param("id") int id);

    Teacher getTeacherB(@Param("id") int id);
}
