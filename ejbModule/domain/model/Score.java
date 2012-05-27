package domain.model;

import java.io.Serializable;

public abstract class Score implements Serializable {

	private static final long serialVersionUID = 8747750033191882577L;
	protected String currentScore;

	public String getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(String currentScore) {
		this.currentScore = currentScore;
	}

	public abstract void updateScore(Score opponentScore);
}
