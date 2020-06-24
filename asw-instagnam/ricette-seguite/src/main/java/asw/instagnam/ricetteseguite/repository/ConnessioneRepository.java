package asw.instagnam.ricetteseguite.repository;

import asw.instagnam.ricetteseguite.domain.Connessione;
import asw.instagnam.ricetteseguite.domain.Ricetta;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface ConnessioneRepository extends CrudRepository <Connessione,Long>{

	public Collection<Connessione> getConnessioniByFollower(String follower);
	public Collection<Connessione> getConnessioniByFollowed(String followed);
}
