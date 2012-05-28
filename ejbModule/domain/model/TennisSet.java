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
public class TennisSet implements Serializable {

	private static final long serialVersionUID = -5910037733532425929L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int setID;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Game> lstGame = new ArrayList<Game>();
	private int pointOfPlayer1 = 0;
	private int pointOfPlayer2 = 0;

	
	@OneToOne(cascade = CascadeType.ALL)
	private Player player1;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player player2;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player winner;
	private boolean endSet = false;

	public TennisSet() {
	}

	public TennisSet(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void addGame(Game game) {
		lstGame.add(game);
	}

	public List<Game> getLstGame() {
		return lstGame;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getPointOfPlayer1() {
		return pointOfPlayer1;
	}

	public int getPointOfPlayer2() {
		return pointOfPlayer2;
	}

	public int getSetID() {
		return setID;
	}

	public Player getWinner() {
		return winner;
	}

	public boolean isEndSet() {
		return endSet;
	}

	private void playGame(Game game) {
		addGame(game);
		game.playGame();
		if (game.getWinner().equals(player1))
			pointOfPlayer1++;
		else
			pointOfPlayer2++;
	}

	public void playSet() {
		Player server = player1;
		Player receiver = player2;
		Game game = null;
		while ((game = GameFactory.createGame(pointOfPlayer1, pointOfPlayer2, server, receiver)) != null) {
			playGame(game);
		}

		if (pointOfPlayer1 > pointOfPlayer2) {
			winner = player1;
		} else if (pointOfPlayer2 > pointOfPlayer1) {
			winner = player2;
		}
	}

	public void setEndSet(boolean endSet) {
		this.endSet = endSet;
	}

	public void setLstGame(ArrayList<Game> lstGame) {
		this.lstGame = lstGame;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void setPointOfPlayer1(int pointOfPlayer1) {
		this.pointOfPlayer1 = pointOfPlayer1;
	}

	public void setPointOfPlayer2(int pointOfPlayer2) {
		this.pointOfPlayer2 = pointOfPlayer2;
	}

	public void setSetID(int setID) {
		this.setID = setID;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}
}
