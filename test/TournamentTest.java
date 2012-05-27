import java.util.ArrayList;

import org.junit.Test;

import domain.model.Player;
import domain.model.Tournament;

public class TournamentTest {

	@Test
	public void test() {
		ArrayList<Player> lstPlayer = new ArrayList<Player>();
		for (int i = 0; i < 8; i++) {
			Player player = new Player("user" + Integer.toString(i));
			player.setPlayerID(i);
			lstPlayer.add(player);
		}

		Tournament tournament = new Tournament(lstPlayer);
		
		tournament.play();
		System.out.println();
		
	}

}
