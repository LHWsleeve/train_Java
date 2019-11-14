package com.sxt.pojo;

import java.util.Objects;

public class User {
    private int Id;
    private String Name;
    private String Pwd;

    public User() {
    }

    public User(int id, String name, String pwd) {
        Id = id;
        Name = name;
        Pwd = pwd;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Id == user.Id &&
                Name.equals(user.Name) &&
                Pwd.equals(user.Pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Pwd);
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Pwd='" + Pwd + '\'' +
                '}';
    }
}
