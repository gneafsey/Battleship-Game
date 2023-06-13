package ClientInterface;

import java.io.Serializable;

public class JoinData implements Serializable {
	private String p_name;
	
	public JoinData(String name) {
		this.p_name = name;
	}
	
	String getJoinGamePlayerName() {
		return p_name;
	}

}
