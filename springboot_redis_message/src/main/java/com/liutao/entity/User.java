package com.liutao.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LIUTAO
 * @version 2017/5/17
 * @see
 */
public class User implements Serializable {
    private static final long serialVersionUID = -7898194272883238670L;
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
