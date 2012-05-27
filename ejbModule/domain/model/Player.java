package domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player implements Serializable {

	private static final long serialVersionUID = -614244911704985059L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
			return playerName.equals(player.playerName);
		} else {
			return false;
		}
	}
}
