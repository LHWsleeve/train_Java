package com.guigu.dao;

import com.guigu.bean.Teacher;

import java.util.List;

public interface TeacherDao {
    public Teacher getTeacherById(Integer id);
    List<Teacher> getTeacherByCondition(Teacher teacher);
}
