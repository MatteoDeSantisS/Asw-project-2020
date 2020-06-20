package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.ricetteseguite.repository.RicetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RicetteService {

    @Autowired
    private RicetteRepository ricetteRepository;

    public Ricetta createRicetta(String autore, String titolo_ricetta) {
        Ricetta ricetta=new Ricetta(autore,titolo_ricetta);
        ricetta = ricetteRepository.save(ricetta);
        return ricetta;
    }

}
