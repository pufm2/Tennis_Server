package domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TennisSet implements Serializable {

	private static final long serialVersionUID = -5910037733532425929L;
	private int setID;
	private List<Game> lstGame = new ArrayList<Game>();
	private int pointOfPlayer1 = 0;
	private int pointOfPlayer2 = 0;

	private Player player1, player2, winner;
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
		while (pointOfPlayer1 < 6 && pointOfPlayer2 < 6
				&& Math.abs(pointOfPlayer1 - pointOfPlayer2) < 2) {
			playGame(new NormalGame(server, receiver));
			// swap serving
			Player temp = server;
			server = receiver;
			receiver = temp;
		}

		if (pointOfPlayer1 == 6 && pointOfPlayer2 == 6)
			playGame(new TieBreakGame(player1, player2));

		if (pointOfPlayer1 > pointOfPlayer2) {
			winner = player1;
//			System.out.println("player 1 win set: " + pointOfPlayer1 + "-"
//					+ pointOfPlayer2);
		} else if (pointOfPlayer2 > pointOfPlayer1) {
			winner = player2;
//			System.out.println("player 2 win set: " + pointOfPlayer1 + "-"
//					+ pointOfPlayer2);
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