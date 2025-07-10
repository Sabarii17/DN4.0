package com.example.jwtauth.controller;

import com.example.jwtauth.model.TokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@RestController
public class AuthController {

    // Static key for signing (in production, move to secure config)
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Basic ")) {
                return ResponseEntity.status(401).body("Missing or invalid Authorization header");
            }

            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String decodedString = new String(decodedBytes);

            String[] credentials = decodedString.split(":", 2);
            String username = credentials[0];
            String password = credentials[1];

            if (username.equals("user") && password.equals("pwd")) {
                // Create real JWT
                String token = Jwts.builder()
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                        .signWith(SECRET_KEY)
                        .compact();

                return ResponseEntity.ok(new TokenResponse(token));
            } else {
                return ResponseEntity.status(401).body("Invalid username or password");
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
