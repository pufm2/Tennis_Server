package domain.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ScoreTest {
	
	Score score;
	@Before
	public void setUp(){
		score = new Score() {

			private static final long serialVersionUID = 7067061569218456152L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub
				
			}
		};
	}

	@Test
	public void test_setID() {
		score.setId(10);
		
		assertEquals(10, score.getId());
	}
	
	@Test
	public void test_setCurrentScore() {
		score.setCurrentScore("love");
		
		assertEquals("love", score.getCurrentScore());
	}

}
