package com.guigu.bean;

import java.beans.IntrospectionException;

public class Employee {
    private Integer id;
    private String empname;
    private String email;
    private Integer gender;
    private String loginAccount;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public Employee() {
    }

    public Employee(Integer id, String empname, String email, Integer gender) {
        this.id = id;
        this.empname = empname;
        this.email = email;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", loginAccount='" + loginAccount + '\'' +
                '}';
    }
}

