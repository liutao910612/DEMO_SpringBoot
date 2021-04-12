package com.kevin.demo.springboot.graphql.bo;

import java.io.Serializable;

/**
 * <p>
 * Author
 * </p>
 *
 * @author alvinl
 * @date 04/12/21 16:55
 **/
public class Author implements Serializable{
    private Integer id;
    private String name;
    private Integer age;

    public Author() {
    }

    public Author(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
