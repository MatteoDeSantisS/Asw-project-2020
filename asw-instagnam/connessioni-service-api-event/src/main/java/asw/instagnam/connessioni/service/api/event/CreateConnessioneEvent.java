package asw.instagnam.connessioni.service.api.event;

import asw.instagnam.common.api.event.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateConnessioneEvent implements DomainEvent {
    private Long id;
    private String follower;
    private String followed;


}
