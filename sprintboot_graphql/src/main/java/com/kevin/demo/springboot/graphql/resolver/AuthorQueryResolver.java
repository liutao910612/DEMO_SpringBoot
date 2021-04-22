package com.kevin.demo.springboot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kevin.demo.springboot.graphql.bo.Author;
import com.kevin.demo.springboot.graphql.bo.Book;
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
public class AuthorQueryResolver implements GraphQLQueryResolver {
    public List<Author> findAllAuthors() {
        Author author = new Author("scala编程第三版", "电子工业出版社");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        return authors;
    }

    public long countAuthors() {
        return 1L;
    }
}
