package com.example.helloworld;

import com.example.helloworld.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

// @SpringBootTest
public class JwtTest {
    private final String secretString = "your-32-byte-secret-key-your-32-byte";
    private final byte[] keyBytes = secretString.getBytes();
    private final SecretKey secretKey = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());

    @Test
    public void testJwtBasic() {
        Map<String, Object> claims = Map.of("id", 1, "name", "test");
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                .compact();
        System.out.println("token: " + token);
    }

    @Test
    public void testJwtParse() {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidGVzdCIsImlkIjoxLCJleHAiOjE3MTYyMDg4ODV9.pSPEWYMSUKXbiALdGOstU29JY6sGZV0EYTBME47hbSI")
                .getBody();
        System.out.println(claims);
    }

    @Test
    public void testJwtUtils() {
        Map<String, Object> claims = Map.of("id", 1, "name", "test");
        String token = JwtUtils.generateJwt(claims);
        Claims newClaims = JwtUtils.parseJwt(token);
        String name =  newClaims.get("name", String.class);
        String name2 =  (String) claims.get("name");
        Integer id = newClaims.get("id", Integer.class);
        Integer id2 = (Integer) claims.get("id");
        Assertions.assertEquals(name, name2);
        Assertions.assertEquals(id, id2);
        System.out.println(name);
        System.out.println(id);
    }

}
