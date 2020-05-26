package asw.instagnam.connessioni.rest;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateConnessioneRequest {

	private String follower; 
	private String followed;
	
	public String getFollower() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getFollowed() {
		// TODO Auto-generated method stub
		return null;
	} 

}

