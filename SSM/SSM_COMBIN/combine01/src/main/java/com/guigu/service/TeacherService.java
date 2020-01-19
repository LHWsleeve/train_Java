package com.guigu.service;

import com.guigu.bean.Teacher;
import com.guigu.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    public void haha(){

    }

    public Teacher getTeacher(Integer id) {
        Teacher teacherById = teacherDao.getTeacherById(id);
        return teacherById;
    }
}
