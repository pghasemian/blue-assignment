package com.assignment.transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for the transaction module.
 * This class defines beans needed for transaction-related operations.
 */
@Configuration
public class AppConfiguration {

    /**
     * Provides a {@link RestTemplate}
     * bean for making RESTful web service calls.
     *
     * <p>This method can be overridden to provide a custom implementation of
     * RestTemplate if necessary. If you choose to override this method, ensure
     * that the returned RestTemplate is
     * properly configured for your application's
     * needs.
     *
     * @return a configured RestTemplate instance.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
