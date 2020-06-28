package com.company.application;

import com.company.application.config.ApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ApplicationConfiguration.class})
public class StartApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting multi module springBoot application");
        SpringApplication.run(StartApplication.class, args);
    }

}
