package com.sparta.springauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/api/create-cookie").permitAll()
                            .requestMatchers("/api/get-cookie").permitAll()
                            .requestMatchers("/api/create-session").permitAll()
                            .requestMatchers("/api/get-session").permitAll()
                            .requestMatchers("/api/create-jwt").permitAll()
                            .requestMatchers("/api/get-jwt").permitAll()
                            .anyRequest().authenticated()
                    );

            return http.build();
        }
}

