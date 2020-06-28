package com.company.application.controller;

import com.company.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class HelloController {
    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Inject
    private BookService bookService;

    @RequestMapping("/")
    public String index() {
        return "Welcome to multi module springBoot application.";
    }

    @RequestMapping("/getBookIds")
    public String getBookIds() {
        LOGGER.info("Fetching book portfolios");
        return bookService.getPortfolioList().toString();
    }

}
