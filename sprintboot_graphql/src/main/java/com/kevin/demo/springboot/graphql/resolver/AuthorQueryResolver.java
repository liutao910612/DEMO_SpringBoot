package com.kevin.demo.springboot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kevin.publiz.model.Author;
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
        Author author = new Author("kevin", "liu", 28, "People Road", "1745662323");
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("kevin", "liu", 28, "People Road", "1745662323"));
        authors.add(new Author("cube", "zhang", 30, "People Road", "1345622323"));
        return authors;
    }

    public long countAuthors() {
        return 1L;
    }
}
