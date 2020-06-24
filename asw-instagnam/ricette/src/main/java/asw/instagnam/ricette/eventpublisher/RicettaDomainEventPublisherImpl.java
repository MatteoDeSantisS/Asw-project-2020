package asw.instagnam.ricette.eventpublisher;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricette.domain.RicettaDomainEventPublisher;
import asw.instagnam.ricette.service.api.event.RicettaServiceEventChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
@Component
public class RicettaDomainEventPublisherImpl implements RicettaDomainEventPublisher {
    private final Logger logger = Logger.getLogger(RicettaDomainEventPublisher.class.toString());

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = RicettaServiceEventChannel.channelRicette;

    @Override
    public void publish(DomainEvent domainEvent) {
        logger.info("PUBLISHING EVENT: " + domainEvent.toString() + " ON CHANNEL: " + channel);
        template.send(channel, domainEvent);
    }
}
