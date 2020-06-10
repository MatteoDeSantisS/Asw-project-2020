package asw.instagnam.ricetteseguite.repository;

import asw.instagnam.ricetteseguite.domain.RicettaSeguita;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RicetteSeguiteRepository extends CrudRepository<RicettaSeguita,Long> {

    public Collection<RicettaSeguita> getRicetteSeguiteByUtenteFollower(String utenteFollower);
    public Collection<RicettaSeguita> findAll();
}
