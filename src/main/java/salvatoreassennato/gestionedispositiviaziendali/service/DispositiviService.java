package salvatoreassennato.gestionedispositiviaziendali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import salvatoreassennato.gestionedispositiviaziendali.entities.Dispositivo;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;
import salvatoreassennato.gestionedispositiviaziendali.exceptions.BadRequestException;
import salvatoreassennato.gestionedispositiviaziendali.exceptions.NotFoundException;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.NewDispositivoDTO;
import salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi.NewUtenteDTO;
import salvatoreassennato.gestionedispositiviaziendali.repository.DispositiviDAO;
import salvatoreassennato.gestionedispositiviaziendali.repository.UtentiDAO;

import java.util.UUID;

@Service
public class DispositiviService {
    @Autowired
    private DispositiviDAO dispositiviDAO;
    @Autowired
    private  UtentiService utentiService;

    public Page<Dispositivo> getUtenti(int page, int size, String orderBy){
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return dispositiviDAO.findAll(pageable);
    }
    public Dispositivo findById(UUID id) {
        return dispositiviDAO.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
    public Dispositivo save(NewDispositivoDTO body){
        UUID utente_id=body.utente_id();
        Utente utente=this.utentiService.findById(utente_id);
        Dispositivo newDispositivo = new Dispositivo();
        newDispositivo.setUtente(utente);
        newDispositivo.setTipologia(body.tipologia());
        newDispositivo.setStato_dispositivo(body.stato_dispositivo());
        return dispositiviDAO.save(newDispositivo);
    }
    public Dispositivo findByIdAndUpdate(UUID id,Dispositivo body){
        Dispositivo found=this.findById(id);
        found.setTipologia(body.getTipologia());
        found.setStato_dispositivo(body.getStato_dispositivo());

        return dispositiviDAO.save(found);
    }
    public void findByIdAndDelete(UUID utenteid){
        dispositiviDAO.deleteById(utenteid);
    }
}
