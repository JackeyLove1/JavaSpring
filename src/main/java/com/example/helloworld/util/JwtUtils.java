package com.example.helloworld.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String signKey = " your-32-byte-secret-key-your-32-byte";
    private static final Long expire = 1000 * 60 * 60 * 24 * 7L;

    private static final byte[] keyBytes = signKey.getBytes();
    private static final SecretKey secretKey = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());

    public static String generateJwt(Map<String, Object> claims){
        String jwtToken = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expire)) // 1 hour
                .compact();
        return jwtToken;
    }

    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
