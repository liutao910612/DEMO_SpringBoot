package com.kevin.demo.springboot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kevin.publiz.model.Book;
import org.springframework.stereotype.Component;

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
@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    public List<Book> findAllBooks() {
        Book b = new Book("scala编程第三版", "电子工业出版社");
        List<Book> bookList = new ArrayList<>();
        bookList.add(b);
        return bookList;
    }

    public long countBooks() {
        return 1L;
    }
}
