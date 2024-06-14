package br.com.system_monitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/monitor/**") //
                        .allowedOrigins("http://localhost:4200") //
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //
                        .allowedHeaders("Content-Type", "Authorization") //
                        .allowCredentials(true); //
            }
        };
    }
}
