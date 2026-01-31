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
	
	private final String SECRET ="ThisIsASecretKeyForJwtTokenGeneration12345";
	private final long EXPIRATION =1000 * 60 * 60;

	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	//generate token
	
	public String generateToken(String email,String role) {
		return Jwts.builder()
					.setSubject(email)
					.claim("role", role)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
					.signWith(getSigningKey(),SignatureAlgorithm.HS256)
					.compact();
	}
	
	 // Extract email
	public String extractEmail(String token) {
		  return parseToken(token).getBody().getSubject();
		
	}
	
	//Extract Role 
	public String extractRole(String token) {
	    return parseToken(token).getBody().get("role", String.class);
	}

	
	//validate token
	
	public boolean isValid(String token) {
		try {
			 parseToken(token);
			 return true;
		} catch (Exception e) {
			return false; 
		}
	}
	
	//Claim token and return token data 
	private Jws<Claims> parseToken(String token){
		return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
		
	}
	
	
	
}
