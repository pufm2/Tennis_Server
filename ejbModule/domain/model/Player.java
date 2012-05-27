package domain.model;

import java.io.Serializable;

public class Player implements Serializable {

	private static final long serialVersionUID = -614244911704985059L;
	private int playerID;
	private String playerName;
	
	public Player(){
	
	}
	
	public Player(String playerName) {
		this.playerName = playerName;
	}
	
	public int getPlayerID() {
		return playerID;
	}
	
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public boolean equals(Object o) {
		if (o instanceof Player) {
			Player player = (Player) o;
			return playerID == player.playerID;
		} else {
			return false;
		}
	}
}
