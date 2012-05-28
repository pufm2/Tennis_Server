package domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Score implements Serializable {

	private static final long serialVersionUID = 8747750033191882577L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	protected String currentScore;

	public String getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(String currentScore) {
		this.currentScore = currentScore;
	}

	public abstract void updateScore(Score opponentScore);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return currentScore;
	}
}
