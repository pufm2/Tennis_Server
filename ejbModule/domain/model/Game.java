package domain.model;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.Entity;

@Entity
public abstract class Game implements Serializable {

	private static final long serialVersionUID = 1838138265867506941L;
	
	private int gameID;
	private Score scoreServer;
	private Score scoreReceiver;
	
	private Player server, receiver, winner;
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
		Random random = new Random();
		int randomValue;
		
		while (!isEndGame()){
			randomValue = random.nextInt(20);
			serve(randomValue % 2);
			
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
	
	private void refresh() {
		if (scoreServer.getCurrentScore().equals("game")) {
			winner = server;
			endGame = true;
		} else if (scoreReceiver.getCurrentScore().equals("game")) {
			winner = receiver;
			endGame =  true;
		}
	}
}
