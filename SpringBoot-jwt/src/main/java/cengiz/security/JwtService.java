package cengiz.security;

import cengiz.data.dto.KullaniciDto;
import cengiz.data.dto.TokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    public Map<String, Object> extractClaims(String token) {
        return extractAllClaims(token);
    }

    public TokenDto generateToken(KullaniciDto kullaniciDto) {
        return generateToken(new HashMap<>(), kullaniciDto);
    }

    public TokenDto generateToken(Map<String, Object> extraClaims, KullaniciDto kullaniciDto) {
        return buildToken(extraClaims, kullaniciDto);
    }

    public long getExpirationTime() {
        return jwtExpiration;
    }

    private TokenDto buildToken(
            Map<String, Object> extraClaims,
            KullaniciDto kullaniciDto
    ) {
        extraClaims.put("uuid",kullaniciDto.getUuid());
        var subUuid  = UUID.randomUUID().toString();
        extraClaims.put("subUuid",subUuid);
        var token = Jwts
                .builder()
                .setClaims(extraClaims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
        return new TokenDto(token,kullaniciDto.getUuid().toString(),subUuid);
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

