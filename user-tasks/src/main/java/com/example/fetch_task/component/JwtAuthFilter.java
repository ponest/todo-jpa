package com.example.fetch_task.component;

import com.example.fetch_task.services.JwtService;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter{//extends OncePerRequestFilter {

   private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
       this.jwtService = jwtService;
    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String path = request.getServletPath();
//
//        // Allow public endpoints without JWT
//        if (isPublicEndpoint(path)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // Get Authorization header
//        String header = request.getHeader("Authorization");
//
//        if (header == null || !header.startsWith("Bearer ")) {
//            sendUnauthorized(response, "Missing or invalid Authorization header");
//            return;
//        }
//
//        String token = header.substring(7);
//
//        if (token.isBlank()) {
//            sendUnauthorized(response, "JWT token is missing");
//            return;
//        }
//
//        try {
//
//            // Extract username and validate JWT
//            String username = jwtService.extractUsername(token);
//
//            if (username == null || username.isBlank()) {
//                sendUnauthorized(response, "Invalid JWT token");
//                return;
//            }
//
//            // Store authenticated username in current request
//            request.setAttribute("username", username);
//
//            // Continue to requested endpoint
//            filterChain.doFilter(request, response);
//
//        } catch (JwtException | IllegalArgumentException e) {
//            sendUnauthorized(response, "Invalid or expired JWT token");
//        }
//    }
//
//    private boolean isPublicEndpoint(String path) {
//
//        return path.equals("/login")
//                || path.equals("/auth/register")
//                || path.equals("/api/public");
//    }
//
//    private void sendUnauthorized(
//            HttpServletResponse response,
//            String message
//    ) throws IOException {
//
//        if (response.isCommitted()) {
//            return;
//        }
//
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        response.getWriter().write(
//                "{\"status\":false,\"message\":\"" + message + "\"}"
//        );
//    }
}