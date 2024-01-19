package salvatoreassennato.gestionedispositiviaziendali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.gestionedispositiviaziendali.entities.Utente;

import java.util.UUID;

@Repository
public interface UtentiDAO extends JpaRepository<Utente, UUID> {
}
