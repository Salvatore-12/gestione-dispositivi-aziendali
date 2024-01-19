package salvatoreassennato.gestionedispositiviaziendali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.service.UtentiService;

import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtentiController {
    @Autowired
    private UtentiService utentiService;

    public Page<Utente>getUtenti(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String orderBy){
        return utentiService.getUtenti(page, size, orderBy);
    }
    @GetMapping("/{id}")
    public Utente findById(@PathVariable UUID id) {
        return utentiService.findById(id);
    }
}
