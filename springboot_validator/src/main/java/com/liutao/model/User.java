package com.liutao.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户数据模板
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */
public class User {

    @NotEmpty(message = "姓名不能为空")
    private String name;
    private Integer age;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,max = 20,message = "密码长度应该大于6位小于20位")
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
