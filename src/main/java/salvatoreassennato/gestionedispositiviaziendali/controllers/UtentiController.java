package salvatoreassennato.gestionedispositiviaziendali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.NewUtenteDTO;
import salvatoreassennato.gestionedispositiviaziendali.service.UtentiService;

import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtentiController {
    @Autowired
    private UtentiService utentiService;
    @GetMapping
    public Page<Utente>getUtenti(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String orderBy){
        return utentiService.getUtenti(page, size, orderBy);
    }
    @GetMapping("/{id}")
    public Utente findById(@PathVariable UUID id) {
        return utentiService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Utente save(@RequestBody NewUtenteDTO body) {
        return utentiService.save(body);
    }
    @PutMapping("/{id}")
    public Utente findByAndUpdate(@PathVariable UUID id, @RequestBody Utente body) {
        return this.utentiService.findByIdAndUpdate(id,body);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {
        this.utentiService.findByIdAndDelete(id);
    }
}
