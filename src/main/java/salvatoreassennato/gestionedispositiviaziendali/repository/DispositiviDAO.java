package salvatoreassennato.gestionedispositiviaziendali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.gestionedispositiviaziendali.entities.Dispositivo;

import java.util.UUID;

@Repository
public interface DispositiviDAO extends JpaRepository<Dispositivo, UUID> {
}
