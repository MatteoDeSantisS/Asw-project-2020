package asw.instagnam.ricetteseguite.eventListener;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricette.service.api.event.RicettaServiceEventChannel;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteEventHandler;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.DomainEvents;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class RicetteSeguiteEventListener {
    private final Logger logger = Logger.getLogger(RicetteSeguiteEventListener.class.toString());

    @Autowired
    private RicetteSeguiteEventHandler ricetteSeguiteEventHandler;

    @KafkaListener(topics = RicettaServiceEventChannel.channel)
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        logger.info("EVENT LISTENER: " + record.toString());
        DomainEvent event = record.value();
        ricetteSeguiteEventHandler.onEvent(event);
    }



}
