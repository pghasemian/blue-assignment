package com.assignment.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This package contains configuration classes for the customer service.
 * It includes settings for beans, application properties, and any necessary
 * custom configurations needed for the customer-related components.
 */
@Configuration
public class AppConfiguration {

    /**
     * Creates and returns a RestTemplate bean.
     *
     * @return a new instance of RestTemplate.
     *
     * <p>This method can be overridden in subclasses to provide a different
     * configuration of RestTemplate if this class were to be subclassed.
     * It is recommended to use caution when overriding this method to
     * ensure that the application context remains properly configured.</p>
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
