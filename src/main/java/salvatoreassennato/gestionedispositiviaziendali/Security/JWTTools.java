package salvatoreassennato.gestionedispositiviaziendali.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.exceptions.UnauthorizedException;

import java.util.Date;

@Component
public class JWTTools {
    // Ci portiamo dentro la jwt.secret
    @Value("${spring.jwt.secret}")
    private String secret;

    //creiazione del token
    public String CreateToken(Utente utente){
         return Jwts.builder().subject(String.valueOf(utente.getId()))// subject: A chi appartiene il token (id dell'utente)
                .issuedAt(new Date(System.currentTimeMillis()))       // Data di emissione (IAT - Issued At)
                .expiration(new  Date(System.currentTimeMillis()+1000*60*60*24*7))// Data di scadenza del token (Expiration Date)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact(); //firmo il token con il nostro secret
    }
    public void verifyToken(String token) { // Dato un token mi lancia eccezioni in caso di token manipolato/scaduto
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);
        } catch (Exception ex) {
            throw new UnauthorizedException("Problemi col token! Per favore effettua di nuovo il login!");
        }
    }
    public String extractIdFromToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseSignedClaims(token).getPayload().getSubject();
    }
}
