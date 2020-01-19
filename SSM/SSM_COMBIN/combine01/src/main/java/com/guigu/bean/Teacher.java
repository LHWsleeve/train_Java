package com.guigu.bean;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable {
    private Integer id;
    private String teacherName;
    private String className;
    private String address;
    private Date birthDate;

    public Teacher() {
    }

    public Teacher(Integer id, String teacherName, String className, String address, Date birthDate) {
        this.id = id;
        this.teacherName = teacherName;
        this.className = className;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
