package com.tmsolution.settingsapi.utilities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
public class JwtUtility {

    @Value("${jwt.public-key}")
    private String jwtSecret;

    /**
     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     *
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
    public UserDetails parseToken(String token) throws ExpiredJwtException, SignatureException {

        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret.getBytes(Charset.defaultCharset()))
                .parseClaimsJws(token)
                .getBody();

        return User.withUsername(claims.get("unique_name").toString())
                .password("")
                .authorities(claims.get("role").toString())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

    }
}
