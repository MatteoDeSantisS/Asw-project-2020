package asw.instagnam.ricetteseguite.repository;

import asw.instagnam.ricetteseguite.domain.Ricetta;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface RicetteRepository extends CrudRepository<Ricetta,Long> {

	public Collection<Ricetta> getRicetteByAutore(String autore);

}
