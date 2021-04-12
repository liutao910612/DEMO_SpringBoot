package com.kevin.demo.springboot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kevin.demo.springboot.graphql.bo.Author;
import com.kevin.demo.springboot.graphql.bo.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author alvinl
 * @date 04/12/21 17:00
 **/
public class BookQueryResolver implements GraphQLQueryResolver {

    public List<Book> findBooks() {
        Author author = new Author(1,"Bill Venners",40);
        Book b = new Book(1,"scala编程第三版",author,"电子工业出版社");
        List<Book> bookList = new ArrayList<>();
        bookList.add(b);
        return bookList;
    }
}
