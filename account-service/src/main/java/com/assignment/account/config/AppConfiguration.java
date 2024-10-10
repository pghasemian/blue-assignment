package com.assignment.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for the application.
 *
 * This class defines beans that are needed throughout the application.
 */
@Configuration
public class AppConfiguration {

    /**
     * Creates a RestTemplate bean.
     *
     * This method can be overridden in subclasses to provide
     * a custom implementation of RestTemplate if needed.
     *
     * @return a RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
