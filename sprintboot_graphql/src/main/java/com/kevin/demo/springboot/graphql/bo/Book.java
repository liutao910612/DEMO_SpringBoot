package com.kevin.demo.springboot.graphql.bo;

import java.io.Serializable;

/**
 * <p>
 * Book
 * </p>
 *
 * @author alvinl
 * @date 04/12/21 16:57
 **/
public class Book implements Serializable{
    private String title;
    private String publisher;

    public Book() {
    }

    public Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
