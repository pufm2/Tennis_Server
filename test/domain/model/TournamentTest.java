package domain.model;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import domain.model.Player;
import domain.model.Tournament;

public class TournamentTest {

	Tournament tournament;
	List<Player> players;
	
	@Before
	public void setUp(){
		players = new ArrayList<Player>();
		
		for (int i=0; i<10; i++){
			Player player = new Player("Player " + i);
			players.add(player);
		}
		
		tournament = new Tournament(players);
	}
	
	@Test
	public void test_init(){
		assertNotNull(tournament.getPlayers());
	}

	@Test
	public void test_getMatchs(){
		List<Match> matches = new ArrayList<Match>();
		matches.add(new Match());
		
		tournament.setMatchs(matches);
		
		assertEquals(1, tournament.getMatchs().size());
	}
	
	@Test 
	public void test_Play(){
		tournament.play();
		
		assertNotNull(tournament.getWinner());

	}
	
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
	}

}
