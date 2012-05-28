package domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player("nhphat");
	}

	@Test
	public void test_equals() {
		Player player2 = new Player("nhphat");

		assertTrue(player.equals(player2));
	}

	@Test
	public void test_setPlayerID() {
		player.setPlayerID(1);

		assertEquals(1, player.getPlayerID());
	}

	@Test
	public void test_setPlayerName() {
		player.setPlayerName("nhphat");

		assertEquals("nhphat", player.getPlayerName());
	}
}
