package asw.instagnam.ricetteseguite.rest;

import asw.instagnam.ricetteseguite.domain.*; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.logging.Logger; 
import java.util.*; 

@RestController
public class RicetteSeguiteController {

	private final Logger logger = Logger.getLogger(RicetteSeguiteController.class.toString()); 

	@Autowired 
	private RicetteSeguiteService ricetteSeguiteService;

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */ 
	@GetMapping("/ricetteseguite")
	public Collection<RicettaSeguita> getRicetteSeguiteUtente() {
		Collection<RicettaSeguita> ricette = ricetteSeguiteService.getRicetteSeguite();
		logger.info("getRicetteSeguite(): " + ricette);
		return ricette;

	}
	/* Trova tutte le ricette  seguite dal follower */
	@GetMapping("/ricetteseguite-follower/{follower}")
	public Collection<RicettaSeguita> getRicetteSeguiteUtente(@PathVariable String follower) {
		Collection<RicettaSeguita> ricette = ricetteSeguiteService.getRicetteSeguiteFollower(follower);
		if(ricette!=null){
			return ricette;
		}else{
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Connessione not found"
			);
		}

	}



}
