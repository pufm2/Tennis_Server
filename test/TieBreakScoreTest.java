import domain.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TieBreakScoreTest {

	TieBreakScore scoreServer, scoreReceiver;
	String expected;
	String actual;
	
	@Before
	public void setUp(){
		scoreServer = new TieBreakScore();
		scoreReceiver = new TieBreakScore();
		expected = "";
		actual = "";
	}
	
	@Test
	public void testZeroToOne() {
		scoreServer.setCurrentScore("0");
		expected = "1";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testOneToTwo() {
		scoreServer.setCurrentScore("1");
		expected = "2";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testTwoToThree() {
		scoreServer.setCurrentScore("2");
		expected = "3";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testThreeToFour() {
		scoreServer.setCurrentScore("3");
		expected = "4";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testFourToFive() {
		scoreServer.setCurrentScore("4");
		expected = "5";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testFiveToSix() {
		scoreServer.setCurrentScore("5");
		expected = "6";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSixToSeven_ServerWin() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("3");
		expected = "game";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTwoPlayerAreSix() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("6");
		expected = "7";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testTwoPlayerAreSeven() {
		scoreServer.setCurrentScore("7");
		scoreReceiver.setCurrentScore("7");
		expected = "8";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testServerWin() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("5");
		expected = "game";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testServerWin_moreThanSeven() {
		scoreServer.setCurrentScore("8");
		scoreReceiver.setCurrentScore("7");
		expected = "game";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
}
