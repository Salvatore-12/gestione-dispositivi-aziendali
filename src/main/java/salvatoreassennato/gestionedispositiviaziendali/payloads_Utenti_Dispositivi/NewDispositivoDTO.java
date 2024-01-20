package salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi;

import lombok.Getter;
import salvatoreassennato.gestionedispositiviaziendali.entities.Stato_Dispositivo;
import salvatoreassennato.gestionedispositiviaziendali.entities.Tipologia;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;

import java.util.UUID;

public record NewDispositivoDTO(UUID utente_id,
                                Tipologia tipologia,
                                Stato_Dispositivo stato_dispositivo) {
}
