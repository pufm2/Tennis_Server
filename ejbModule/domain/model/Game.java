package domain.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import utils.Utils;

@Entity
public abstract class Game implements Serializable {

	private static final long serialVersionUID = 1838138265867506941L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gameID;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Score scoreServer;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Score scoreReceiver;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player server;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player receiver;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player winner;
	
	private boolean endGame = false;

	public Game() {

	}

	public Game(Score scoreServer, Score scoreReceiver, Player server,
			Player receiver) {

		this.scoreServer = scoreServer;
		this.scoreReceiver = scoreReceiver;
		this.server = server;
		this.receiver = receiver;
		
		refresh();
	}

	public Player getWinner(){
		refresh();
		return winner;
	}

	public boolean isEndGame(){

		refresh();
		return endGame;
	}

	// Play game
	public void playGame(){
		
		while (!isEndGame()){
			int randomValue = Utils.getRandomNumber(2);
			serve(randomValue);
			
			refresh();
		}
	}

	// Server serve a ball
	public void serve(int serveResult){
		if (serveResult == 1){
			// Server win point
			scoreServer.updateScore(scoreReceiver);
			}
		else{
			// Receiver win point
			scoreReceiver.updateScore(scoreServer);
		}
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public Score getScoreServer() {
		return scoreServer;
	}

	public void setScoreServer(Score scoreServer) {
		this.scoreServer = scoreServer;
	}

	public Score getScoreReceiver() {
		return scoreReceiver;
	}

	public void setScoreReceiver(Score scoreReceiver) {
		this.scoreReceiver = scoreReceiver;
	}

	public Player getServer() {
		return server;
	}

	public void setServer(Player server) {
		this.server = server;
	}

	public Player getReceiver() {
		return receiver;
	}

	public void setReceiver(Player receiver) {
		this.receiver = receiver;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}
	
	void refresh() {
		if (scoreServer.getCurrentScore().equals("game")) {
			winner = server;
			endGame = true;
		} else if (scoreReceiver.getCurrentScore().equals("game")) {
			winner = receiver;
			endGame =  true;
		}
	}
}
