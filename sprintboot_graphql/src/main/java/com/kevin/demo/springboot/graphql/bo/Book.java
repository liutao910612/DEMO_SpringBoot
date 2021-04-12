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
    private Integer id;
    private String name;
    private Author author;
    private String publisher;

    public Book() {
    }

    public Book(Integer id, String name, Author author, String publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
