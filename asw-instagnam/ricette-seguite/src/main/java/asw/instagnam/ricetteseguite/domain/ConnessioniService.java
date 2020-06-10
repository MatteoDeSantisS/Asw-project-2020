package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.ricetteseguite.repository.ConnessioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConnessioniService {


    @Autowired
    private ConnessioneRepository connessioneRepository;


    public Connessione createConnessione(String follower, String followed) {
        Connessione connessione=new Connessione(follower,followed);
        connessione=connessioneRepository.save(connessione);
        return connessione;
    }


}
