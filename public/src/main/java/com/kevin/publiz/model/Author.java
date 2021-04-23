package com.kevin.publiz.model;

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
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
    private String email;
    public Author() {
    }

    public Author(String firstName, String lastName, Integer age, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
