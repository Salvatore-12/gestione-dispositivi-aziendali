package salvatoreassennato.gestionedispositiviaziendali.payloads_Utenti_Dispositivi;

import salvatoreassennato.gestionedispositiviaziendali.entities.Role;

public record NewUtenteDTO(String nome, String cognome, String email, String password, Role role) {
}
