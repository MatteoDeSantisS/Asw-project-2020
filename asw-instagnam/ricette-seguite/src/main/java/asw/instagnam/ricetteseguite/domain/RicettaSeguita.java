package asw.instagnam.ricetteseguite.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class RicettaSeguita {

    private String utenteFollower;
    @Id
    private Long idRicetta;
    private String autoreRicetta;
    private String titoloRicetta;

    public RicettaSeguita(String utenteFollower, Long idRicetta, String autoreRicetta, String titoloRicetta) {
        this();
        this.utenteFollower = utenteFollower;
        this.idRicetta = idRicetta;
        this.autoreRicetta = autoreRicetta;
        this.titoloRicetta = titoloRicetta;
    }
}


