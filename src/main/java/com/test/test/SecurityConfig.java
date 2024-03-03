package com.test.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable() // Consider re-enabling CSRF protection in production
                .authorizeHttpRequests(authorize -> authorize // REMOVE ALL CONFIGURATION
                        .anyRequest().permitAll()); // REMOVE ALL CONFIGURATION - TEMPORARY FOR DEVELOPMENT

        // Add more configuration if needed - but not related to authentication

        return httpSecurity.build();
    }
}