package org.crash.reporting.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final int MAX_AGE_SEC = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v3/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST")
                .maxAge(MAX_AGE_SEC);
    }

}
