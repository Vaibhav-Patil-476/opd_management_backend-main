package com.OPD_Managemnet_System.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.OPD_Managemnet_System.Response.Error_Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

	// ObjectMapper is used to convert Java objects into JSON responses
	// It is injected by Spring container
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void commence(HttpServletRequest request, // Incoming HTTP request
			HttpServletResponse response, // HTTP response to be sent
			AuthenticationException authException // Exception thrown by Spring Security
	) throws IOException, ServletException {

		// Create a custom error response object
		// 401 status indicates Unauthorized access
		Error_Response error = new Error_Response(HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized: Invalid or missing JWT token");

		// Set HTTP status code to 401 (Unauthorized)
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		// Set response type as JSON
		response.setContentType("application/json");

		// Write the error response as JSON to the output stream
		objectMapper.writeValue(response.getOutputStream(), error);
	}
}
