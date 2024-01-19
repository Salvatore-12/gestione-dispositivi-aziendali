package salvatoreassennato.gestionedispositiviaziendali.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Entity
@Table(name="dispositivi")
@Getter
@Setter
@ToString
public class Dispositivo {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="utente_id",nullable = false)
    private Utente utente;
    @Enumerated(EnumType.STRING)
    private Tipologia tipologia;
    @Enumerated(EnumType.STRING)
    private Stato_Dispositivo Stato_dispositivo;

}
