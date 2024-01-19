package salvatoreassennato.gestionedispositiviaziendali.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Getter
@Setter
@ToString
public class Utente {
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String nome_Utente;
    private String nome;
    private String cognome;
    private String email;

}
