package asw.instagnam.ricette.domain;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricette.service.api.event.CreateRicettaEvent;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class RicetteService {

	@Autowired
	private RicetteRepository ricetteRepository;
	@Autowired
	private RicettaDomainEventPublisher ricettaDomainEventPublisher;

 	public RicettaCompleta createRicetta(String autore, String titolo, String preparazione) {
		RicettaCompleta ricetta = new RicettaCompleta(autore, titolo, preparazione); 
		ricetta = ricetteRepository.save(ricetta);
		DomainEvent event =new CreateRicettaEvent(ricetta.getId(),ricetta.getAutore(),ricetta.getTitolo());
		ricettaDomainEventPublisher.publish(event);
		return ricetta;
	}

 	public RicettaCompleta getRicetta(Long id) {
		RicettaCompleta ricetta = ricetteRepository.findById(id).orElse(null);
		return ricetta;
	}

	public Collection<RicettaCompleta> getRicette() {
		Collection<RicettaCompleta> ricette = ricetteRepository.findAll();
		return ricette;
	}

	public Collection<RicettaCompleta> getRicetteByAutore(String autore) {
		Collection<RicettaCompleta> ricette = ricetteRepository.findAllByAutore(autore);
		return ricette;
	}

}
