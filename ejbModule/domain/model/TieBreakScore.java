package domain.model;

public class TieBreakScore extends Score {

	private static final long serialVersionUID = -8587604155526648913L;

	public TieBreakScore(){
		currentScore = "0";
	}

	public String getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(String currentScore) {
		this.currentScore = currentScore;
	}

	public void updateScore(Score opponentScore) {
		opponentScore = (TieBreakScore)opponentScore;
		
		int currentScore = Integer.parseInt(getCurrentScore());
		int newScore = currentScore + 1;
		setCurrentScore(String.valueOf(newScore));

		int opponentPoint = Integer.parseInt(opponentScore.getCurrentScore());

		if (currentScore < 6){
			currentScore++;
			setCurrentScore(String.valueOf(currentScore));
		}
		else{
			currentScore++;
			if (currentScore - opponentPoint >= 2){
				setCurrentScore("game");
			}
		}
	}
}
