package domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatchTest {

	Match match;
	Player player1, player2;

	@Before
	public void setUp() {
		player1 = new Player("nhphat");
		player2 = new Player("lxhoan");
		match = new Match(player1, player2);
	}

	@Test
	public void test_Init() {
		assertEquals("nhphat", match.getPlayer1().getPlayerName());
		assertEquals("lxhoan", match.getPlayer2().getPlayerName());
		assertEquals(0, match.getLstSet().size());
	}

	@Test
	public void test_addSet() {
		TennisSet set = new TennisSet();
		match.addSet(set);

		assertEquals(1, match.getLstSet().size());
	}

	@Test
	public void test_getListSet() {
		for (int i = 0; i < 5; i++) {
			TennisSet set = new TennisSet();
			match.addSet(set);
		}

		assertEquals(5, match.getLstSet().size());
	}

	@Test
	public void test_getMatchID() {
		match.setMatchID(10);
		assertEquals(10, match.getMatchID());
	}

	@Test
	public void test_getPlayer1() {
		TennisSet set = new TennisSet(player1, player2);
		match.addSet(set);

		assertEquals("nhphat", match.getPlayer1().getPlayerName());
	}

	@Test
	public void test_getPlayer1SetWon() {
		match.setPlayer1SetWon(2);

		assertEquals(2, match.getPlayer1SetWon());
	}

	@Test
	public void test_getPlayer2() {
		TennisSet set = new TennisSet(player1, player2);
		match.addSet(set);

		assertEquals("lxhoan", match.getPlayer2().getPlayerName());
	}

	@Test
	public void test_getPlayer2SetWon() {
		match.setPlayer1SetWon(1);

		assertEquals(1, match.getPlayer1SetWon());
	}

	@Test
	public void test_getWinner() {
		match.setPlayer1SetWon(2);
		match.play();
		assertEquals(player1, match.getWinner());
	}

	@Test
	public void test_play() {
		match.setPlayer1SetWon(2);
		match.setPlayer2SetWon(0);
		match.play();
		assertEquals(player1, match.getWinner());
	}

	@Test
	public void test_setMatchID() {
		match.setMatchID(1);

		assertEquals(1, match.getMatchID());
	}

	@Test
	public void setPlayer1() {
		match.setPlayer1(player1);
		assertEquals(player1, match.getPlayer1());
	}

	@Test
	public void setPlayer1SetWon() {
		match.setPlayer1SetWon(2);
		assertEquals(2, match.getPlayer1SetWon());
	}

	@Test
	public void test_setLstSet() {
		TennisSet set = new TennisSet();
		match.addSet(set);

		assertEquals(1, match.getLstSet().size());
	}

	@Test
	public void setPlayer2() {
		match.setPlayer1(player2);
		assertEquals(player2, match.getPlayer2());
	}

	@Test
	public void setPlayer2SetWon() {
		match.setPlayer2SetWon(2);
		assertEquals(2, match.getPlayer2SetWon());
	}

	@Test
	public void setWinner() {
		match.setWinner(player1);
		assertEquals(player1, match.getWinner());
	}
}
