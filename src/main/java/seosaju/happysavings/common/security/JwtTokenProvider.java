package seosaju.happysavings.common.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Slf4j
public class JwtTokenProvider {

    private static final String JWT_SECRET = "secretKey";

    // 토큰 유효시간
    private static final int JWT_EXPIRATION_MS = 604800000;

    public static String generateToken(Authentication authentication) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);

        return Jwts.builder()
                .setSubject((String) authentication.getPrincipal())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public static String getUserId(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public static boolean validateToken(String token) {

        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("this token had expired");
        } catch (UnsupportedJwtException e) {
            log.error("unsupported JWT token");
        } catch (MalformedJwtException e) {
            log.error("invalid JWT token");
        } catch (SignatureException e) {
            log.error("invalid JWT signature");
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty.");
        }

        return false;
    }
}
