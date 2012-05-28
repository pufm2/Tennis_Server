package domain.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TieBreakScoreTest {

	TieBreakScore scoreServer, scoreReceiver;
	
	@Before
	public void setUp(){
		scoreServer = new TieBreakScore();
		scoreReceiver = new TieBreakScore();
	}
	
	@Test
	public void test_Init(){
		assertEquals("0", scoreServer.getCurrentScore());
		assertEquals("0", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void test_Zero_To_One() {
		scoreServer.setCurrentScore("0");
		scoreServer.updateScore(scoreReceiver);
		
		assertEquals("1", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_One_To_Two() {
		scoreServer.setCurrentScore("1");
		scoreServer.updateScore(scoreReceiver);
		
		assertEquals("2", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Two_To_Three() {
		scoreServer.setCurrentScore("2");
		scoreServer.updateScore(scoreReceiver);
		
		assertEquals("3", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Three_To_Four() {
		scoreServer.setCurrentScore("3");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("4", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Four_To_Five() {
		scoreServer.setCurrentScore("4");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("5", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Five_To_Six() {
		scoreServer.setCurrentScore("5");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("6", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Six_To_Seven_ServerWin() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("3");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("game", scoreServer.getCurrentScore());
	}

	@Test
	public void test_Two_Player_Are_Six() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("6");
		scoreServer.updateScore(scoreReceiver);
		
		assertEquals("7", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Two_Player_Are_Seven() {
		scoreServer.setCurrentScore("7");
		scoreReceiver.setCurrentScore("7");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("8", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Server_Win() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("5");
		scoreServer.updateScore(scoreReceiver);
		
		assertEquals("game", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_Server_Loss() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("7");
		scoreReceiver.updateScore(scoreServer);

		assertEquals("game", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void test_MoreThanSeven_ServerWin() {
		scoreServer.setCurrentScore("8");
		scoreReceiver.setCurrentScore("7");
		scoreServer.updateScore(scoreReceiver);

		assertEquals("game", scoreServer.getCurrentScore());
	}
	
	@Test
	public void test_MoreThanSeven_ServerLoss() {
		scoreServer.setCurrentScore("8");
		scoreReceiver.setCurrentScore("9");
		scoreReceiver.updateScore(scoreServer);
		
		assertEquals("game", scoreReceiver.getCurrentScore());
	}
}
