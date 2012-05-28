package domain.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class NormalScoreTest {

	NormalScore scoreServer, scoreReceiver;
	
	@Before
	public void setUp(){
		scoreServer = new NormalScore();
		scoreReceiver = new NormalScore();
	}
	
	@Test 
	public void test_Init(){
		assertEquals("love", scoreServer.getCurrentScore());
		assertEquals("love", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void test_Love_To_Fifteen() {
		scoreServer.setCurrentScore("love");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("15", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Fifteen_To_Thirty() {
		scoreServer.setCurrentScore("15");
		scoreServer.updateScore(scoreReceiver);
		
		assertEquals("30", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Thirty_To_Forty() {
		scoreServer.setCurrentScore("30");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("40", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Forty_To_Game() {
		scoreServer.setCurrentScore("40");
		scoreServer.updateScore(scoreReceiver);
		
		assertEquals("game",  scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Forty_To_Deuce(){
		scoreReceiver.setCurrentScore("40");
		
		scoreServer.setCurrentScore("30");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("deuce", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Deuce_To_Advantage(){
		scoreReceiver.setCurrentScore("deuce");
		
		scoreServer.setCurrentScore("deuce");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("advantage", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Advantage_To_Game(){
		scoreReceiver.setCurrentScore("deuce");
		
		scoreServer.setCurrentScore("advantage");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("game", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Advantage_To_Deuce(){
		scoreReceiver.setCurrentScore("deuce");
		
		scoreServer.setCurrentScore("advantage");
		scoreReceiver.updateScore(scoreServer);
		assertEquals("deuce", scoreServer.getCurrentScore());
	}
}
