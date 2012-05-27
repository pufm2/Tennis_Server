package domain.model;

import javax.persistence.Entity;

@Entity
public class NormalScore extends Score {

	private static final long serialVersionUID = -4678229424096642105L;

	public NormalScore(){
		currentScore = "love";
	}

	public void updateScore(Score opponentScore) {
	
		opponentScore = (NormalScore)opponentScore;
		
		String opponentPoint = opponentScore.getCurrentScore();

		if (currentScore.equals("love"))
			setCurrentScore("15");
		else if (currentScore.equals("15"))
			setCurrentScore("30");
		else if (currentScore.equals("30")){
			if (!opponentPoint.equals("40")){
				setCurrentScore("40");
			}
			else{
				setCurrentScore("deuce");
				opponentScore.setCurrentScore("deuce");
			}
		}			
		else if (currentScore.equals("40")){
			if (!opponentPoint.equals("40")){
				setCurrentScore("game");	
			}
			else{
				setCurrentScore("deuce");
				opponentScore.setCurrentScore("deuce");
			}
		}
		else if (currentScore.equals("deuce")){
			if (opponentPoint.equals("advantage")){
				opponentScore.setCurrentScore("deuce");
			}
			else
				setCurrentScore("advantage");
		}
		else if (currentScore.equals("advantage")){
			setCurrentScore("game");
		}
	}	
}
