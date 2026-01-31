package com.OPD_Managemnet_System.Security;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.OPD_Managemnet_System.Response.Error_Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			String authHeader = request.getHeader("Authorization");
			System.out.println("Incoming URL: " + request.getRequestURI());
			System.out.println("Authorization header: " + authHeader);

			// 1️⃣ No JWT → continue (Spring Security will block later)
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {

				System.out.println("No JWT token found, passing filter chain");

				filterChain.doFilter(request, response);
				return;
			}

			// 2️⃣ Extract token from header
			String token = authHeader.substring(7);

			System.out.println("JWT token: " + token);

			// 3️⃣ Validate token
//			if (!jwtUtil.isValid(token)) {
//				System.out.println("Invalid JWT token");
//
//				  throw new RuntimeException("Invalid JWT");
//			}
//
//			// 4️⃣ Extract user details
//			String email = jwtUtil.extractEmail(token);
//			String role = jwtUtil.extractRole(token);
//
//			System.out.println("JWT email: " + email + ", role: " + role);
//
//			// 5️⃣ Set authentication with proper UserDetails principal
//			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
//			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null,
//					List.of(authority) // authorities
//			);
//
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//
//			// 6️⃣ Continue filter chain ONCE
//			filterChain.doFilter(request, response);
			// 3️⃣ Validate token
			if (jwtUtil.isValid(token)) {

				// 4️⃣ Extract user details(email/ role) from token
				String email = jwtUtil.extractEmail(token);
				String role = jwtUtil.extractRole(token);

				System.out.println("JWT email: " + email + ", role: " + role);

				// 5️⃣ Set role as authority to application
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email,
						null, List.of(authority) // authorities
				);

				SecurityContextHolder.getContext().setAuthentication(authentication);

			}

			// 6️⃣ Continue filter chain ONCE
			filterChain.doFilter(request, response);

			//handling some exception of authentication
		} catch (ExpiredJwtException ex) {
			sendError(response, "JWT token expired");

		} catch (MalformedJwtException ex) {
			sendError(response, "Invalid JWT token");

		} catch (SignatureException ex) {
			sendError(response, "JWT signature invalid");

		}
	}

	// sending an error response of auth to user 
	private void sendError(HttpServletResponse response, String message) throws IOException {
		// filling exception output details to error response cong.
		Error_Response error = new Error_Response(HttpServletResponse.SC_UNAUTHORIZED, message);
		response.resetBuffer();
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");

		new ObjectMapper().writeValue(response.getOutputStream(), error);
	}
}
