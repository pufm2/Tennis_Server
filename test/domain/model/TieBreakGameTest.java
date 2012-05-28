package domain.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TieBreakGameTest {

	TieBreakGame game;
	TieBreakScore scoreServer, scoreReceiver;
	Player server, receiver;
	int serveResult;
	
	@Before
	public void setUp() {
		scoreServer = new TieBreakScore();
		scoreReceiver = new TieBreakScore();

		server = new Player();
		server.setPlayerName("NHPhat");

		receiver = new Player();
		receiver.setPlayerName("LXHoan");

		game = new TieBreakGame(server, receiver);
		game.setScoreServer(scoreServer);
		game.setScoreReceiver(scoreReceiver);
	}

	@Test
	public void test_Init() {
		assertEquals("0", scoreServer.getCurrentScore());
		assertEquals("0", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void test_ContinueGame_0_0() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		assertFalse(game.isEndGame());
	}
	
	@Test
	public void test_ContinueGame_1_0() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		assertFalse(game.isEndGame());
	}
	
	@Test
	public void test_ContinueGame_0_1() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		assertFalse(game.isEndGame());
	}
	
	@Test
	public void test_ContinueGame_6_5() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		assertFalse(game.isEndGame());
	}
	
	@Test
	public void test_ContinueGame_5_6() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		assertFalse(game.isEndGame());
	}
	
	@Test
	public void test_ContinueGame_6_6() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		assertFalse(game.isEndGame());
	}
	
	@Test
	public void test_ContinueGame_7_5() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		assertFalse(game.isEndGame());
	}
	
	@Test
	public void testEndGame_ServerWin() {
		scoreServer.setCurrentScore("game");
		
		assertTrue(game.isEndGame());
	}
	
	@Test
	public void testEndGame_ServerLoss() {
		scoreReceiver.setCurrentScore("game");
		
		assertTrue(game.isEndGame());
	}
	
	@Test
	public void testGetWinner_NoWinner() {
		scoreServer.setCurrentScore("5");
		scoreReceiver.setCurrentScore("6");
		
		assertNull(game.getWinner());
	}
	
	@Test
	public void testGetWinner_ServerWin() {
		scoreServer.setCurrentScore("game");

		assertEquals(server, game.getWinner());
	}

	@Test
	public void testGetWinner_ServerLoss() {
		scoreReceiver.setCurrentScore("game");
		
		assertEquals(receiver, game.getWinner());
	}
	
	@Test
	public void testServe_0_0_ServerWin() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("1", scoreServer.getCurrentScore());
		assertEquals("0", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_0_0_ServerLoss() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("0");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("0", scoreServer.getCurrentScore());
		assertEquals("1", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_1_0_ServerWin() {
		scoreServer.setCurrentScore("1");
		scoreReceiver.setCurrentScore("0");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("2", scoreServer.getCurrentScore());
		assertEquals("0", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_1_0_ServerLoss() {
		scoreServer.setCurrentScore("1");
		scoreReceiver.setCurrentScore("0");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("1", scoreServer.getCurrentScore());
		assertEquals("1", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_0_1_ServerWin() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("1");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("1", scoreServer.getCurrentScore());
		assertEquals("1", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_0_1_ServerLoss() {
		scoreServer.setCurrentScore("0");
		scoreReceiver.setCurrentScore("1");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("0", scoreServer.getCurrentScore());
		assertEquals("2", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_6_5_ServerWin() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("5");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("game", scoreServer.getCurrentScore());
		assertEquals("5", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_6_5_ServerLoss() {
		scoreServer.setCurrentScore("6");
		scoreReceiver.setCurrentScore("5");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("6", scoreServer.getCurrentScore());
		assertEquals("6", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_7_6_ServerWin() {
		scoreServer.setCurrentScore("7");
		scoreReceiver.setCurrentScore("6");

		serveResult = 1;
		game.serve(serveResult);

		assertEquals("game", scoreServer.getCurrentScore());
		assertEquals("6", scoreReceiver.getCurrentScore());
	}
	
	@Test
	public void testServe_7_6_ServerLoss() {
		scoreServer.setCurrentScore("7");
		scoreReceiver.setCurrentScore("6");

		serveResult = 0;
		game.serve(serveResult);

		assertEquals("7", scoreServer.getCurrentScore());
		assertEquals("7", scoreReceiver.getCurrentScore());
	}
}
