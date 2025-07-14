package com.jobPortal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/api/users/register","/api/users/test","/api/users/login").permitAll() // Allow registration without auth
	                .anyRequest().authenticated() // Secure all other endpoints
	            )
	            .httpBasic(); // Use Basic Auth for protected endpoints

	        return http.build();
	    }

}
