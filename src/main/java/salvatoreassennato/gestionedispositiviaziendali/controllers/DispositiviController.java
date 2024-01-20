package salvatoreassennato.gestionedispositiviaziendali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.gestionedispositiviaziendali.entities.Dispositivo;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.NewDispositivoDTO;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.NewUtenteDTO;
import salvatoreassennato.gestionedispositiviaziendali.service.DispositiviService;

import java.util.UUID;
@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {
    @Autowired
    private DispositiviService dispositiviService;
    @GetMapping
    public Page<Dispositivo> getUtenti(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String orderBy){
        return dispositiviService.getUtenti(page, size, orderBy);
    }
    @GetMapping("/{id}")
    public Dispositivo findById(@PathVariable UUID id) {
        return dispositiviService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dispositivo save(@RequestBody NewDispositivoDTO body) {
        return dispositiviService.save(body);
    }
    @PutMapping("/{id}")
    public Dispositivo findByAndUpdate(@PathVariable UUID id, @RequestBody Dispositivo body) {
        return this.dispositiviService.findByIdAndUpdate(id,body);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {
        this.dispositiviService.findByIdAndDelete(id);
    }
}
