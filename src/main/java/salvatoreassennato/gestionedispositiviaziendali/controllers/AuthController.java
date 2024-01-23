package salvatoreassennato.gestionedispositiviaziendali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.exceptions.BadRequestException;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.NewUtenteDTO;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.NewUtenteResponseDTO;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.UtenteLoginDTO;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.UtenteLoginResponseDTO;
import salvatoreassennato.gestionedispositiviaziendali.service.AuthService;
import salvatoreassennato.gestionedispositiviaziendali.service.UtentiService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UtentiService utentiService;
    @PostMapping("/login")
    public UtenteLoginResponseDTO login(@RequestBody UtenteLoginDTO body){
       String accessToken= authService.authenticateUtente(body);
       return new UtenteLoginResponseDTO(accessToken);
    }
    @PostMapping("/register")
    public NewUtenteResponseDTO createUtente(@RequestBody @Validated NewUtenteDTO newUtenteDTO, BindingResult validation){
    // Per completare la validazione devo in qualche maniera fare un controllo del tipo:
    // se ci sono errori -> manda risposta con 400 Bad Request
        System.out.println(validation);
        if (validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException("Ci sono errori nel payload!"); // L'eccezione arriverà agli error handlers tra i quali c'è quello che manderà la risposta con status code 400
        } else {
            Utente newUser = utentiService.save(newUtenteDTO);
            return new NewUtenteResponseDTO(newUser.getId());
        }
    }
}
