package domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Player implements Serializable {

	private static final long serialVersionUID = -614244911704985059L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int playerID;
	
	@ManyToMany
	private List<Match> matchs = new ArrayList<Match>();

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

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}
	
	public void addMatch(Match match) {
		matchs.add(match);
	}

	public boolean equals(Object o) {
		if (o instanceof Player) {
			Player player = (Player) o;
			return playerName.equals(player.playerName);
		} else {
			return false;
		}
	}
	
	public String toString() {
		return playerName;
	}
}
