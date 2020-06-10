package asw.instagnam.connessioni.eventpublisher;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioni.domain.Connessione;
import asw.instagnam.connessioni.domain.ConnessioneDomainEventPublisher;
import asw.instagnam.connessioni.service.api.event.ConnessioniServiceEventChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ConnessioneDomainEventPublisherImpl implements ConnessioneDomainEventPublisher {

    private final Logger logger = Logger.getLogger(ConnessioneDomainEventPublisherImpl.class.toString());
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = ConnessioniServiceEventChannel.channel;

    @Override
    public void publish(DomainEvent event) {
        logger.info("PUBLISHING EVENT: " + event.toString() + " ON CHANNEL: " + channel);
        template.send(channel, event);

    }
}
