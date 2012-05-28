package domain.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class SetTest {

	TennisSet set;
	Player player1, player2;

	@Before
	public void setUp() throws Exception {
		player1 = new Player("nhphat");
		player2 = new Player("lxhoan");

		set = new TennisSet(player1, player2);
	}

	@Test
	public void test_init() {
		assertNotNull(set.getPlayer1());
		assertNotNull(set.getPlayer2());
	}

	@Test
	public void test_addGame() {
		Game game = new Game() {

			private static final long serialVersionUID = -3343132351003945452L;
		};
		set.addGame(game);

		assertEquals(1, set.getLstGame().size());
	}

	@Test
	public void test_getLstGame() {
		Game game = new Game() {

			private static final long serialVersionUID = -3343132351003945452L;
		};
		set.addGame(game);

		assertEquals(1, set.getLstGame().size());
	}

	@Test
	public void test_getWinner() {
		set.setPointOfPlayer1(6);
		set.setPointOfPlayer2(3);
		set.playSet();

		assertEquals(player1, set.getWinner());
	}

	@Test
	public void test_playSet() {
		set.setPointOfPlayer1(7);
		set.setPointOfPlayer2(5);
		set.playSet();

		assertEquals(player1, set.getWinner());
	}

	@Test
	public void test_setEndSet() {
		set.setEndSet(true);

		assertTrue(set.isEndSet());
	}

	@Test
	public void test_setLstGame() {
		ArrayList<Game> lstGame = new ArrayList<Game>();
		lstGame.add(new Game() {

			private static final long serialVersionUID = -6489990492519680365L;
		});
		set.setLstGame(lstGame);

		assertEquals(1, set.getLstGame().size());

	}

	@Test
	public void test_setPlayer1() {
		set.setPlayer1(player1);

		assertEquals(player1, set.getPlayer1());
	}

	@Test
	public void test_setPlayer2() {
		set.setPlayer2(player2);

		assertEquals(player2, set.getPlayer2());
	}

	@Test
	public void test_setPointOfPlayer1() {
		set.setPointOfPlayer1(3);

		assertEquals(3, set.getPointOfPlayer1());
	}

	@Test
	public void test_setPointOfPlayer2() {
		set.setPointOfPlayer2(5);

		assertEquals(5, set.getPointOfPlayer2());
	}

	@Test
	public void test_setSetID() {
		set.setSetID(10);

		assertEquals(10, set.getSetID());
	}

	@Test
	public void test_setWinner() {
		set.setWinner(player1);

		assertEquals(player1, set.getWinner());
	}
}
