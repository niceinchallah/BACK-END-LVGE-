package com.test.test;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Specify the URL pattern to which this configuration applies
                .allowedOrigins("http://localhost:3000")  // Allow requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow these HTTP methods
                .allowCredentials(true);  // Allow sending cookies along with the request
    }
}