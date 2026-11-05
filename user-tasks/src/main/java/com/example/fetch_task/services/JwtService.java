package com.example.fetch_task.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

//    @Value("${jwt.secret}")
//    private String secret;
//
//    private SecretKey getSigningKey() {
//        return Keys.hmacShaKeyFor(
//                Decoders.BASE64.decode(secret)
//        );
//    }
//
//    // Generate JWT token
//    public String generateToken(String username) {
//
//        return Jwts.builder()
//                .subject(username)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + 3600000))
//                .signWith(getSigningKey())
//                .compact();
//    }
//
//    // Extract username from JWT
//    public String extractUsername(String token) {
//
//        return Jwts.parser()
//                .verifyWith(getSigningKey()).build()
//                .parseSignedClaims(token).getPayload()
//                .getSubject();
//    }
//
//    // Validate JWT
//    public boolean isTokenValid(String token) {
//        try {
//            return extractUsername(token) != null;
//        } catch (JwtException | IllegalArgumentException e) {
//            return false;
//        }
//    }
}