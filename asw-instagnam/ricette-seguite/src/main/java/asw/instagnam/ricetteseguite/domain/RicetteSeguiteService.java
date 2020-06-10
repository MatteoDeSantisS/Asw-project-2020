package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.ricetteseguite.repository.ConnessioneRepository;
import asw.instagnam.ricetteseguite.repository.RicetteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*; 

@Service
@Transactional
public class RicetteSeguiteService {

	@Autowired
	private ConnessioneRepository connessioneRepository;

	@Autowired 
	private RicetteRepository ricetteRepository;



	public Ricetta createRicetta(String autore, String titolo_ricetta) {
	Ricetta ricetta=new Ricetta(autore,titolo_ricetta);
	ricetta=ricetteRepository.save(ricetta);
	return ricetta;
    }


	/* da implementare in un'altra classe/
	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */
	public Collection<Ricetta> getRicetteSeguite(String utente) {
		Collection<Ricetta> ricette = new ArrayList<>(); 
		Collection<Connessione> connessioni = connessioneRepository.getConnessioniByFollower(utente);
		for (Connessione connessione : connessioni) {
			String followed = connessione.getFollowed();
			Collection<Ricetta> ricetteByFollowed = connessioneRepository.getRicetteByAutore(followed);
			ricette.addAll(ricetteByFollowed);
		}
		return ricette; 
	}


}
