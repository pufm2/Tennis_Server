package domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	Game game;

	@Before
	public void setUp() throws Exception {
		Score scoreServer = new NormalScore();
		Score scoreReceiver = new NormalScore();
		Player server = new Player("nhphat");
		Player receiver = new Player("lxhoan");
		game = new Game(scoreServer, scoreReceiver, server, receiver) {

		private static final long serialVersionUID = 1L;

		};
	}

	@Test
	public void test_getEndGame() {
		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {

			}
		});
		game.getScoreReceiver().setCurrentScore("game");
		game.refresh();

		assertTrue(game.isEndGame());
	}

	@Test
	public void test_getGameID() {
		game.setGameID(10);

		assertEquals(10, game.getGameID());
	}

	@Test
	public void test_getReceiver() {
		game.setReceiver(new Player("nhphat"));

		assertNotNull(game.getReceiver());
	}

	@Test
	public void test_getScoreReceiver() {
		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});

		assertNotNull(game.getScoreReceiver());
	}

	@Test
	public void test_getScoreServer() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});

		assertNotNull(game.getScoreServer());
	}

	@Test
	public void test_getServer() {
		game.setServer(new Player("nhphat"));

		assertNotNull(game.getServer());
	}

	@Test
	public void test_getWinner_ServerLoss() {
		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});
		game.getScoreReceiver().setCurrentScore("game");

		assertNotNull(game.getWinner());
		assertEquals(game.getReceiver(), game.getWinner());
	}

	@Test
	public void test_getWinner_ServerWin() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});
		game.getScoreServer().setCurrentScore("game");

		assertNotNull(game.getWinner());
		assertEquals(game.getServer(), game.getWinner());
	}

	@Test
	public void test_isEndGame_NoWinner() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});

		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});

		game.getScoreServer().setCurrentScore("40");
		game.getScoreReceiver().setCurrentScore("30");

		assertEquals(false, game.isEndGame());
	}

	@Test
	public void test_isEndGame_ServerLoss() {
		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});
		game.getScoreReceiver().setCurrentScore("game");

		assertTrue(game.isEndGame());
	}

	@Test
	public void test_isEndGame_ServerWin() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});
		game.getScoreServer().setCurrentScore("game");

		assertTrue(game.isEndGame());
	}

	@Test
	public void test_refesh_endGame() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});
		game.getScoreServer().setCurrentScore("game");

		assertEquals(game.getServer(), game.getWinner());
		assertTrue(game.isEndGame());
	}

	@Test
	public void test_refesh_NotEndGame() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});
		game.getScoreServer().setCurrentScore("40");

		assertNull(game.getWinner());
		assertFalse(game.isEndGame());
	}

	@Test
	public void test_Serve_IncreaseReceiverScore_Fifteen_To_Thirty() {
		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				game.getScoreReceiver().currentScore = "30";
			}
		});
		game.getScoreReceiver().setCurrentScore("15");
		game.serve(0);

		assertEquals("30", game.getScoreReceiver().getCurrentScore());
	}

	@Test
	public void test_Serve_IncreaseReceiverScore_Forty_To_Game() {
		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				game.getScoreReceiver().currentScore = "game";
			}
		});
		game.getScoreReceiver().setCurrentScore("40");
		game.serve(0);

		assertEquals("game", game.getScoreReceiver().getCurrentScore());
	}

	@Test
	public void test_Serve_IncreaseReceiverScore_Thirty_To_Forty() {
		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				game.getScoreReceiver().currentScore = "40";
			}
		});
		game.getScoreReceiver().setCurrentScore("30");
		game.serve(0);

		assertEquals("40", game.getScoreReceiver().getCurrentScore());
	}

	@Test
	public void test_Serve_IncreaseServerScore_Fifteen_To_Thirty() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				game.getScoreServer().currentScore = "30";
			}
		});
		game.getScoreServer().setCurrentScore("15");
		game.serve(1);

		assertEquals("30", game.getScoreServer().getCurrentScore());
	}

	@Test
	public void test_Serve_IncreaseServerScore_Forty_To_Game() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				game.getScoreServer().currentScore = "game";
			}
		});
		game.getScoreServer().setCurrentScore("40");
		game.serve(1);

		assertEquals("game", game.getScoreServer().getCurrentScore());
	}

	@Test
	public void test_Serve_IncreaseServerScore_Thirty_To_Forty() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				game.getScoreServer().currentScore = "40";
			}
		});
		game.getScoreServer().setCurrentScore("30");
		game.serve(1);

		assertEquals("40", game.getScoreServer().getCurrentScore());
	}

	@Test
	public void test_setEndGame() {
		game.setEndGame(true);

		assertTrue(game.isEndGame());
	}

	@Test
	public void test_setGameID() {
		game.setGameID(10);

		assertEquals(10, game.getGameID());
	}

	@Test
	public void test_setReceiver() {
		game.setReceiver(new Player("nhphat"));

		assertEquals("nhphat", game.getReceiver().getPlayerName());
	}

	@Test
	public void test_setScoreReceiver() {
		game.setScoreReceiver(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});

		assertNotNull(game.getScoreReceiver());
	}

	@Test
	public void test_setScoreServer() {
		game.setScoreServer(new Score() {

			private static final long serialVersionUID = 1L;

			@Override
			public void updateScore(Score opponentScore) {
				// TODO Auto-generated method stub

			}
		});

		assertNotNull(game.getScoreServer());
	}

	@Test
	public void test_setServer() {
		game.setServer(new Player("nhphat"));

		assertEquals("nhphat", game.getServer().getPlayerName());
	}

	@Test
	public void test_setWinner() {
		game.setWinner(new Player("nhphat"));

		assertEquals("nhphat", game.getWinner().getPlayerName());
	}
}
