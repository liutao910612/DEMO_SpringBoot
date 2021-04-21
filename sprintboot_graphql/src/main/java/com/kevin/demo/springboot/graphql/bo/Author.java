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
    private String firstName;
    private String lastName;
    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
