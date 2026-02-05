package com.OPD_Managemnet_System.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.OPD_Managemnet_System.OPDEntitys.Role;

@Component
public class JWTUtil {

	// Secret key used for signing JWT tokens
	// Should ideally be stored in application properties for security
	private final String SECRET = "ThisIsASecretKeyForJwtTokenGeneration12345";

	// Token expiration time in milliseconds (here: 1 hour)
	private final long EXPIRATION = 1000 * 60 * 60;

	// Generate signing key from the secret using HMAC SHA algorithm
	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	// ---------------------- GENERATE TOKEN ----------------------

	// Generates a JWT token with email and role as claims
	public String generateToken(String email, String role) {
		return Jwts.builder().setSubject(email) // Set email as subject
				.claim("role", role) // Add user role as a claim
				.setIssuedAt(new Date()) // Token issue time
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)) // Token expiry
				.signWith(getSigningKey(), SignatureAlgorithm.HS256) // Sign with secret key
				.compact(); // Build token
	}

	// ---------------------- EXTRACT INFORMATION ----------------------

	// Extracts email (subject) from a JWT token
	public String extractEmail(String token) {
		return parseToken(token).getBody().getSubject();
	}

	// Extracts role from JWT token claims
	public String extractRole(String token) {
		return parseToken(token).getBody().get("role", String.class);
	}

	// ---------------------- VALIDATE TOKEN ----------------------

	// Checks if the token is valid (not expired and properly signed)
	public boolean isValid(String token) {
		try {
			parseToken(token); // Will throw exception if invalid
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// ---------------------- PARSE TOKEN ----------------------

	// Parses a JWT token and returns the claims
	private Jws<Claims> parseToken(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigningKey()) // Set signing key
				.build().parseClaimsJws(token); // Parse JWT claims
	}
}
