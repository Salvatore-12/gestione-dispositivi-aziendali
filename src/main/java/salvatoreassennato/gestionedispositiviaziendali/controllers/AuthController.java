package salvatoreassennato.gestionedispositiviaziendali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.UtenteLoginDTO;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.UtenteLoginResponseDTO;
import salvatoreassennato.gestionedispositiviaziendali.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/login")
    public UtenteLoginResponseDTO login(@RequestBody UtenteLoginDTO body){
       String accessToken= authService.authenticateUtente(body);
       return new UtenteLoginResponseDTO(accessToken);
    }
}
