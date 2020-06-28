package com.company.service.configuration;

import com.company.service.book.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is equivalent to having an xml context file in which all beans are declared
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public BookService bookService(){
        BookService bookService = new BookService();
        return bookService;
    }

}
