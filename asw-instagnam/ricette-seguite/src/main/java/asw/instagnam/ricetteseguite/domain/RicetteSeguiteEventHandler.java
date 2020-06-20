package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioni.service.api.event.CreateConnessioneEvent;
import asw.instagnam.ricette.service.api.event.CreateRicettaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class RicetteSeguiteEventHandler {

    private final Logger logger = Logger.getLogger(RicetteSeguiteEventHandler.class.toString());
    @Autowired
    private RicetteSeguiteService ricetteSeguiteService;
    @Autowired
    private RicetteService ricetteService;
    @Autowired
    private ConnessioniService connessioniService;

    public void onEvent(DomainEvent event){

        logger.info("PROCESSING COMMAND: " + event);
        if (event.getClass().equals(CreateRicettaEvent.class)) {
            CreateRicettaEvent cre = (CreateRicettaEvent) event;
            createRicetta(cre);

        } else {
            if(event.getClass().equals(CreateConnessioneEvent.class)){
                CreateConnessioneEvent cce= (CreateConnessioneEvent) event;
                createConnessione(cce);
            }
            else {
                logger.info("UNKNOWN COMMAND: " + event);
            }
        }
    }

    private void createRicetta(CreateRicettaEvent event) {
        ricetteService.createRicetta(event.getAutore(), event.getTitolo_ricetta());
    }

    private  void createConnessione(CreateConnessioneEvent event){

        connessioniService.createConnessione(event.getFollower(),event.getFollowed());
        ricetteSeguiteService.createRicetteSeguite(event.getFollower(),event.getFollowed());
    }
}
