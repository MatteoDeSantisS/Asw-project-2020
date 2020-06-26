package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.ricetteseguite.repository.ConnessioneRepository;
import asw.instagnam.ricetteseguite.repository.RicetteRepository;
import asw.instagnam.ricetteseguite.repository.RicetteSeguiteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*; 

@Service
@Transactional
public class RicetteSeguiteService {

	@Autowired
	private RicetteSeguiteRepository ricetteSeguiteRepository;

	@Autowired
	private ConnessioneRepository connessioneRepository;

	@Autowired
	private RicetteRepository ricetteRepository;

	public Collection<RicettaSeguita> createRicetteSeguite(String follower, String followed) {

		Collection<Ricetta> ricette = ricetteRepository.getRicetteByAutore(followed);
		for (Ricetta ricetta : ricette) {
			RicettaSeguita ricettaSeguita = new RicettaSeguita(follower, ricetta.getId(), followed, ricetta.getTitolo());
			ricetteSeguiteRepository.save(ricettaSeguita);
		}
		Collection<RicettaSeguita> ricetteSeguite = ricetteSeguiteRepository.getRicetteSeguiteByUtenteFollower(follower);
		return ricetteSeguite;
	}

	public Collection<RicettaSeguita> getRicetteSeguiteFollower(String follower) {
		return ricetteSeguiteRepository.getRicetteSeguiteByUtenteFollower(follower);
	}

	public Collection<RicettaSeguita> getRicetteSeguite() {
		return ricetteSeguiteRepository.findAll();
	}
}