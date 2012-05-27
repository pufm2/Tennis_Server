import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import domain.model.*;

public class GameTest {

	NormalGame game;
	NormalScore scoreServer, scoreReceiver;
	Player server, receiver;

	@Before
	public void setUp(){
		scoreServer = new NormalScore();
		scoreReceiver = new NormalScore();
		
		server = new Player();
		receiver = new Player();
		
		game = new NormalGame(server, receiver);
		game.setScoreServer(scoreServer);
		game.setScoreReceiver(scoreReceiver);
	}

	@Test
	public void testContinueGame_ReceiverWin() {
		scoreReceiver.setCurrentScore("40");
		scoreServer.setCurrentScore("40");
		
		Assert.assertEquals(false, game.isEndGame());
	}

	@Test
	public void testGetWinner_NoWinner(){
		scoreServer.setCurrentScore("40");
		scoreReceiver.setCurrentScore("40");
		Assert.assertNull(game.getWinner());
	}

	@Test
	public void testGetWinner_Receiver(){
		scoreReceiver.setCurrentScore("game");
		Assert.assertEquals(receiver, game.getWinner());
	}

	@Test
	public void testGetWinner_Server(){
		scoreServer.setCurrentScore("game");
		Assert.assertEquals(server, game.getWinner());
	}

	@Test
	public void testIsEndGame_ReceiverWin() {
		scoreReceiver.setCurrentScore("game");
		Assert.assertEquals(true, game.isEndGame());
	}

	@Test
	public void testIsEndGame_ServerWin() {
		scoreReceiver.setCurrentScore("game");
		Assert.assertEquals(true, game.isEndGame());
	}

	@Test
	public void testPrintScore(){
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("15");
		
		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);
		
		String expected = "15 - 15";
		String actual = scoreServer.getCurrentScore() + " - " + scoreReceiver.getCurrentScore();
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testServeAdvantage_Deuce_ServerLost(){
		scoreServer.setCurrentScore("advantage");
		scoreReceiver.setCurrentScore("deuce");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("deuce", scoreServer.getCurrentScore());
		Assert.assertEquals("deuce", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeAdvantage_Deuce_ServerWin(){
		scoreServer.setCurrentScore("advantage");
		scoreReceiver.setCurrentScore("deuce");

		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);

		Assert.assertEquals("game", scoreServer.getCurrentScore());
		Assert.assertEquals("deuce", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeDeuce_Deuce_ServerLost(){
		scoreServer.setCurrentScore("deuce");
		scoreReceiver.setCurrentScore("deuce");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("deuce", scoreServer.getCurrentScore());
		Assert.assertEquals("advantage", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeDeuce_Deuce_ServerWin(){
		scoreServer.setCurrentScore("deuce");
		scoreReceiver.setCurrentScore("deuce");

		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);

		Assert.assertEquals("advantage", scoreServer.getCurrentScore());
		Assert.assertEquals("deuce", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeFifty_Forty_ServerLost() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("40");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("15", scoreServer.getCurrentScore());
		Assert.assertEquals("game", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeFifty_Thirty_ServerLost() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("30");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("15", scoreServer.getCurrentScore());
		Assert.assertEquals("40", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeFifty_Thirty_ServerWin() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("30");

		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);

		Assert.assertEquals("30", scoreServer.getCurrentScore());
		Assert.assertEquals("30", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeForty_Thirty_ServerLost() {
		scoreServer.setCurrentScore("40");
		scoreReceiver.setCurrentScore("30");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("deuce", scoreServer.getCurrentScore());
		Assert.assertEquals("deuce", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeForty_Thirty_ServerWin() {
		scoreServer.setCurrentScore("40");
		scoreReceiver.setCurrentScore("30");

		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);

		Assert.assertEquals("game", scoreServer.getCurrentScore());
		Assert.assertEquals("30", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeLove_Fifty_ServerLost() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("15");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("love", scoreServer.getCurrentScore());
		Assert.assertEquals("30", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeLove_Fifty_ServerWin() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("15");

		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);

		Assert.assertEquals("15", scoreServer.getCurrentScore());
		Assert.assertEquals("15", scoreReceiver.getCurrentScore());
	}


	@Test
	public void testServeLove_Forty_ServerLost() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("40");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("love", scoreServer.getCurrentScore());
		Assert.assertEquals("game", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeStartGame_ServerLost() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("love");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("love", scoreServer.getCurrentScore());
		Assert.assertEquals("15", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeStartGame_ServerWin() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("love");

		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);

		System.out.println(scoreServer.getCurrentScore());
		System.out.println(scoreReceiver.getCurrentScore());

		Assert.assertEquals("15", scoreServer.getCurrentScore());
		Assert.assertEquals("love", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeThirty_Forty_ServerLost() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("40");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("30", scoreServer.getCurrentScore());
		Assert.assertEquals("game", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeThirty_Forty_ServerWin(){
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("40");

		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);

		Assert.assertEquals("deuce", scoreServer.getCurrentScore());
		Assert.assertEquals("deuce", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeThirty_Thirty_ServerLost() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("30");

		// Assume that server lost point
		int serveResult = 0;
		game.serve(serveResult);

		Assert.assertEquals("30", scoreServer.getCurrentScore());
		Assert.assertEquals("40", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServeThirty_Thirty_ServerWin() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("30");

		// Assume that server win point
		int serveResult = 1;
		game.serve(serveResult);

		Assert.assertEquals("40", scoreServer.getCurrentScore());
		Assert.assertEquals("30", scoreReceiver.getCurrentScore());
	}
}
