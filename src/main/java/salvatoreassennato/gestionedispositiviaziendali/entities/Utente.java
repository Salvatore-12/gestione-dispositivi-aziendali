package salvatoreassennato.gestionedispositiviaziendali.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Entity
@Table(name="utenti")
@Getter
@Setter
@ToString
public class Utente {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String nome_Utente;
    private String nome;
    private String cognome;
    private String email;
    private String password; //messo attributo password

}
