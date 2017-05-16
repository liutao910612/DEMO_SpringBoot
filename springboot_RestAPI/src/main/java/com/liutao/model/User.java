package com.liutao.model;

/**
 * Created by zl on 2015/8/27.
 */
public class User {
    private String name;
    private Integer age;
    private String password;

    public User() {
    }

    public User(String name, Integer age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
