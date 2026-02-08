package com.OPD_Managemnet_System.Security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	// JWT filter that intercepts requests and validates tokens
	@Autowired
	private JwtAuthenticationFilter jwtFilter;

	// Entry point for unauthorized requests, returns custom error
	@Autowired
	private JwtAuthEntryPoint jwtAuthEntryPoint;

	// ---------------------- SECURITY FILTER CHAIN ----------------------
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
				// Disable CSRF since we are using JWT (state-less)
				.csrf(csrf -> csrf.disable())

				// Handle unauthorized requests with custom entry point
				.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthEntryPoint))

				// Define URL access rules
				.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/login/doctor", // Allow doctor login
						"/auth/login/reception", // Allow reception login
						"/auth/login/admin", // Allow admin login
						"/api/doctor/register",// Allow doctor registration
						"/api/email/send"//allow to send user 
				).permitAll() // Permit these endpoints
						.anyRequest().authenticated() // All other requests need authentication
				)

				// Set session management to stateless (JWT does not use server session)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// Add JWT filter before UsernamePasswordAuthenticationFilter
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
