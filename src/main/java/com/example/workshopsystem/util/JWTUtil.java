package com.example.workshopsystem.util;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import com.example.workshopsystem.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil 
{
		private final String secret="my-super-secret-key-123456789-9876543321-741852963";
		private final SecretKey key=Keys.hmacShaKeyFor(secret.getBytes());
		private final long expiration_time=1000*60*60;
		
		public String generateToken(Long userId)
		{
			return Jwts.builder()
				.claim("userId", userId)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration_time))
				.signWith(key,SignatureAlgorithm.HS256)
				.compact();	
		}
		public Claims extractClaims(String token)
		{
			return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();	
		}
		public Long extractUserId(String token)
		{
	        Long userId= extractClaims(token).get("userId", Long.class);
	        return userId;
	    }
		public boolean validateToken(Long userId, User user,String token) 
		{
			return userId.equals(user.getUserId()) && !isTokenExpired(token);
		}
		private boolean isTokenExpired(String token)
		{
			
			return extractClaims(token).getExpiration().before(new Date());
		}

}
