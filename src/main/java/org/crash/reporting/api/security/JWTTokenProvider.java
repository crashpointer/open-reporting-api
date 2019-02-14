package org.crash.reporting.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JWTTokenProvider.class);

    @Value("${app.jwt.secret.key}")
    private String jwtSecretKey;

    @Value("${app.jwt.expiration.time}")
    private int jwtExpirationTime;

    public String createToken(Authentication authentication) {
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        Date now = new Date();

        return Jwts.builder()
                .setSubject(Integer.toString(userDetail.getId()))
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtExpirationTime))
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();
    }

    int parseUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(token)
                .getBody();

        return Integer.parseInt(claims.getSubject());
    }

    boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return false;
    }

}
