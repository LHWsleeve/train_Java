package com.guigu.dao;

import com.guigu.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    public Teacher getTeacherById(Integer id);
    List<Teacher> getTeacherByCondition(Teacher teacher);
    List<Teacher> getTeacherByIdIn(@Param("ids") List<Integer> ids);
    List<Teacher> getTeacherByConditionChoose(Teacher teacher);

}
