package domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Match implements Serializable {

	private static final long serialVersionUID = -1090083898925539191L;

	public static final int MAX_SET = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matchID;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player player1;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player player2;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player winner;

	private int player1SetWon = 0;
	private int player2SetWon = 0;

	@OneToMany(cascade = CascadeType.ALL)
	private List<TennisSet> lstSet = new ArrayList<TennisSet>();

	public Match() {
	}

	public Match(Player player1, Player player2) {

		this.player1 = player1;
		this.player2 = player2;
	}

	public void addSet(TennisSet set) {
		lstSet.add(set);
	}

	public int getMatchID() {
		return matchID;
	}

	public Player getPlayer1() {
		return player1;
	}

	public int getPlayer1SetWon() {
		return player1SetWon;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getPlayer2SetWon() {
		return player2SetWon;
	}

	public Player getWinner() {
		return winner;
	}

	public void play() {
		while (Math.abs(player1SetWon - player2SetWon) < 2
				&& lstSet.size() < MAX_SET) {
			playMatch(new TennisSet(player1, player2));
		}
		if (player1SetWon > player1SetWon) {
			winner = player1;
		} else {
			winner = player2;
		}

	}

	private void playMatch(TennisSet set) {
		addSet(set);
		set.playSet();
		if (player1.equals(set.getWinner())) {
			player1SetWon++;
		} else
			player1SetWon++;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer1SetWon(int player1SetWon) {
		this.player1SetWon = player1SetWon;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void setPlayer2SetWon(int player2SetWon) {
		this.player2SetWon = player2SetWon;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public List<TennisSet> getLstSet() {
		return lstSet;
	}

	public void setLstSet(List<TennisSet> lstSet) {
		this.lstSet = lstSet;
	}
}
