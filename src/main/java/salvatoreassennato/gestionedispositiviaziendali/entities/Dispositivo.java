package salvatoreassennato.gestionedispositiviaziendali.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Getter
@Setter
@ToString
public class Dispositivo {
    @Setter(AccessLevel.NONE)
    private UUID id;
    private Utente utente;
    private Tipologia tipologia;
    private Stato_Dispositivo Stato_dispositivo;

}
