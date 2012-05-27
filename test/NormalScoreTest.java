import domain.model.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NormalScoreTest {

	NormalScore scoreServer, scoreReceiver;
	String expected;
	String actual;
	
	@Before
	public void setUp(){
		scoreServer = new NormalScore();
		scoreReceiver = new NormalScore();
		expected = "";
		actual = "";
	}
	
	@Test
	public void testLoveToFifteen() {
		scoreServer.setCurrentScore("love");
		expected = "15";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testFifteenToThirty() {
		scoreServer.setCurrentScore("15");
		expected = "30";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testThirtyToForty() {
		scoreServer.setCurrentScore("30");
		expected = "40";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testFortyToGame() {
		scoreServer.setCurrentScore("40");
		expected = "game";
		
		scoreServer.updateScore(scoreReceiver);
		actual = scoreServer.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}
}
