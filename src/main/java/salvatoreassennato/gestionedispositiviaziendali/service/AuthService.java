package salvatoreassennato.gestionedispositiviaziendali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.UtenteLoginDTO;

@Service
public class AuthService {

    @Autowired
    UtentiService utentiService;

   public String authenticateUtente(UtenteLoginDTO body){
       //1)verifico se l'email dell' utente sia nel DB
       Utente utente=utentiService.findByEmail(body.email());
       //2)



       return "token";
   }
}
