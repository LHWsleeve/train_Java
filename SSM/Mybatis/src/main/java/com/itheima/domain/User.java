package com.itheima.domain;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String addrtess;

    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String addrtess) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.addrtess = addrtess;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddrtess() {
        return addrtess;
    }

    public void setAddrtess(String addrtess) {
        this.addrtess = addrtess;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", addrtess='" + addrtess + '\'' +
                '}';
    }
}
