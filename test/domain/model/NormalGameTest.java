package domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NormalGameTest {

	NormalGame game;
	NormalScore scoreServer, scoreReceiver;
	Player server, receiver;
	int serveResult;

	@Before
	public void setUp() {
		scoreServer = new NormalScore();
		scoreReceiver = new NormalScore();

		server = new Player();
		server.setPlayerName("NHPhat");

		receiver = new Player();
		receiver.setPlayerName("LXHoan");

		game = new NormalGame(server, receiver);
		game.setScoreServer(scoreServer);
		game.setScoreReceiver(scoreReceiver);
	}

	@Test
	public void test_Init() {
		assertEquals("love", scoreServer.getCurrentScore());
		assertEquals("love", scoreReceiver.getCurrentScore());
	}

	@Test
	public void test_ContinueGame_Love_Love() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("love");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Love_Fifteen() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("15");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Love_Thirty() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("30");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Love_Forty() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("40");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Fifteen_Thirty() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("30");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Fifteen_Forty() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("40");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Thirty_Forty() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("40");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Deuce_Deuce() {
		scoreServer.setCurrentScore("deuce");
		scoreReceiver.setCurrentScore("deuce");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Advantage_Deuce() {
		scoreServer.setCurrentScore("advantage");
		scoreReceiver.setCurrentScore("deuce");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Fifteen_Love() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("love");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Thirty_Love() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("love");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Forty_Love() {
		scoreServer.setCurrentScore("forty");
		scoreReceiver.setCurrentScore("love");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Thirty_Fifty() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("15");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Forty_Fifteen() {
		scoreServer.setCurrentScore("40");
		scoreReceiver.setCurrentScore("15");

		assertFalse(game.isEndGame());
	}

	@Test
	public void test_ContinueGame_Forty_Thirty() {
		scoreServer.setCurrentScore("40");
		scoreReceiver.setCurrentScore("30");

		assertFalse(game.isEndGame());
	}

	@Test
	public void testEndGame_ServerWin() {
		scoreServer.setCurrentScore("game");

		assertTrue(game.isEndGame());
	}

	@Test
	public void testEndGame_ReceiverWin() {
		scoreReceiver.setCurrentScore("game");

		assertTrue(game.isEndGame());
	}

	@Test
	public void testGetWinner_NoWinner() {
		scoreServer.setCurrentScore("40");
		scoreReceiver.setCurrentScore("40");

		assertNull(game.getWinner());
	}

	@Test
	public void testGetWinner_Server() {
		scoreServer.setCurrentScore("game");

		assertEquals(server, game.getWinner());
	}

	@Test
	public void testGetWinner_Receiver() {
		scoreReceiver.setCurrentScore("game");

		assertEquals(receiver, game.getWinner());
	}

	@Test
	public void testScoreResult() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("15");

		serveResult = 1;
		game.serve(serveResult);

		String expected = "15 - 15";
		String actual = scoreServer.getCurrentScore() + " - "
				+ scoreReceiver.getCurrentScore();

		assertEquals(expected, actual);
	}

	@Test
	public void testServeAdvantage_Deuce_ServerLost() {
		scoreServer.setCurrentScore("advantage");
		scoreReceiver.setCurrentScore("deuce");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("deuce", scoreServer.getCurrentScore());
		assertEquals("deuce", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeAdvantage_Deuce_ServerWin() {
		scoreServer.setCurrentScore("advantage");
		scoreReceiver.setCurrentScore("deuce");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("game", scoreServer.getCurrentScore());
		assertEquals("deuce", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeDeuce_Deuce_ServerLost() {
		scoreServer.setCurrentScore("deuce");
		scoreReceiver.setCurrentScore("deuce");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("deuce", scoreServer.getCurrentScore());
		assertEquals("advantage", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeDeuce_Deuce_ServerWin() {
		scoreServer.setCurrentScore("deuce");
		scoreReceiver.setCurrentScore("deuce");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("advantage", scoreServer.getCurrentScore());
		assertEquals("deuce", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeFifty_Forty_ServerLost() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("40");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("15", scoreServer.getCurrentScore());
		assertEquals("game", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeFifty_Thirty_ServerLost() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("30");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("15", scoreServer.getCurrentScore());
		assertEquals("40", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeFifty_Thirty_ServerWin() {
		scoreServer.setCurrentScore("15");
		scoreReceiver.setCurrentScore("30");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("30", scoreServer.getCurrentScore());
		assertEquals("30", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeForty_Thirty_ServerLost() {
		scoreServer.setCurrentScore("40");
		scoreReceiver.setCurrentScore("30");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("deuce", scoreServer.getCurrentScore());
		assertEquals("deuce", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeForty_Thirty_ServerWin() {
		scoreServer.setCurrentScore("40");
		scoreReceiver.setCurrentScore("30");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("game", scoreServer.getCurrentScore());
		assertEquals("30", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeLove_Fifty_ServerLost() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("15");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("love", scoreServer.getCurrentScore());
		assertEquals("30", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeLove_Fifty_ServerWin() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("15");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("15", scoreServer.getCurrentScore());
		assertEquals("15", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeLove_Forty_ServerLost() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("40");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("love", scoreServer.getCurrentScore());
		assertEquals("game", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeStartGame_ServerLost() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("love");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("love", scoreServer.getCurrentScore());
		assertEquals("15", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeStartGame_ServerWin() {
		scoreServer.setCurrentScore("love");
		scoreReceiver.setCurrentScore("love");

		serveResult = 1;
		game.serve(serveResult);

		System.out.println(scoreServer.getCurrentScore());
		System.out.println(scoreReceiver.getCurrentScore());

		assertEquals("15", scoreServer.getCurrentScore());
		assertEquals("love", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeThirty_Forty_ServerLost() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("40");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("30", scoreServer.getCurrentScore());
		assertEquals("game", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeThirty_Forty_ServerWin() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("40");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("deuce", scoreServer.getCurrentScore());
		assertEquals("deuce", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeThirty_Thirty_ServerLost() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("30");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("30", scoreServer.getCurrentScore());
		assertEquals("40", scoreReceiver.getCurrentScore());
	}

	@Test
	public void testServeThirty_Thirty_ServerWin() {
		scoreServer.setCurrentScore("30");
		scoreReceiver.setCurrentScore("30");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("40", scoreServer.getCurrentScore());
		assertEquals("30", scoreReceiver.getCurrentScore());
	}
}
