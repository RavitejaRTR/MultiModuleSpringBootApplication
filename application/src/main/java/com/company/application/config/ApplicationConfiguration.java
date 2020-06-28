package com.company.application.config;

import com.company.service.configuration.ServiceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfiguration.class})
public class ApplicationConfiguration {

}
