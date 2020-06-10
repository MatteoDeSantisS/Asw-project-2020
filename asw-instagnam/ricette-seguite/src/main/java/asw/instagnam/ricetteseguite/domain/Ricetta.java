package asw.instagnam.ricetteseguite.domain;

import lombok.*;
import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/* Ricetta (in formato breve). */
@Entity
@Data @NoArgsConstructor
public class Ricetta {
	@Id
	@GeneratedValue
	private Long id; 
	private String autore; 
	private String titolo; 

	public Ricetta( String autore, String titolo){
		this();
		this.autore=autore;
		this.titolo=titolo;
	}
}
