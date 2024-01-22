package salvatoreassennato.gestionedispositiviaziendali.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvatoreassennato.gestionedispositiviaziendali.Security.JWTTools;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.exceptions.UnauthorizedException;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.UtenteLoginDTO;

@Service
public class AuthService {
    @Autowired
    private UtentiService utentiService;
    //Portare dentro la classe JWTTools
    @Autowired
    private JWTTools jwtTools;

    public String authenticateUtente(UtenteLoginDTO body) {
        //1)verifico se l'email dell' utente sia nel DB
        Utente utente = utentiService.findByEmail(body.email());
        // 2. In caso affermativo, verifichiamo se la password fornita corrisponde a quella trovata nel db
        if (body.password().equals(utente.getPassword())) {
            // 3. Se le credenziali sono OK --> Genere un token JWT e lo ritorno
            return jwtTools.CreateToken(utente);
        } else {
            // 4. Se le credenziali NON sono OK --> 401 (Unauthorized)
            throw new UnauthorizedException("Credenziali non valide!");
        }
    }

}
