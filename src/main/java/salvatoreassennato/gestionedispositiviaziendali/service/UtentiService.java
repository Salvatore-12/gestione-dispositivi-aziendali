package salvatoreassennato.gestionedispositiviaziendali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import salvatoreassennato.gestionedispositiviaziendali.entities.Role;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.exceptions.BadRequestException;
import salvatoreassennato.gestionedispositiviaziendali.exceptions.NotFoundException;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.NewUtenteDTO;
import salvatoreassennato.gestionedispositiviaziendali.repository.UtentiDAO;

import java.util.UUID;

@Service
public class UtentiService {
    @Autowired
    private UtentiDAO utentiDAO;

    public Page<Utente> getUtenti(int page, int size, String orderBy){
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return utentiDAO.findAll(pageable);
    }
    public Utente findById(UUID id) {
        return utentiDAO.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
    public Utente save(NewUtenteDTO body){
        utentiDAO.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " è già in uso!");
        });
        Utente newUtente = new Utente();
        newUtente.setNome(body.nome());
        newUtente.setCognome(body.cognome());
        newUtente.setEmail(body.email());
        newUtente.setPassword(body.password());
        newUtente.setRole(Role.UTENTE);
        return utentiDAO.save(newUtente);
    }

    public Utente findByIdAndUpdate(UUID id,Utente body){
        Utente found=this.findById(id);
        found.setNome_Utente(body.getNome_Utente());
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        return utentiDAO.save(found);
    }
    public void findByIdAndDelete(UUID id){
        Utente found=this.findById(id);
        this.utentiDAO.delete(found);
    }
  //Creazione metodo FindByEmail
    public Utente findByEmail(String email)throws NotFoundException {
        return utentiDAO.findByEmail(email).orElseThrow(()->new NotFoundException("Utente con email"+email+"trovata!"));

    }
}
