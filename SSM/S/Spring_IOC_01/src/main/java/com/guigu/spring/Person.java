package com.guigu.spring;

public class Person {
    private int age;
    private String email;
    private String gender;
    private String lastName;


    public Person() {
        System.out.println("创建成功");
    }

    public Person(int age, String email, String gender, String lastName) {
        System.out.println("有参构造器");
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
