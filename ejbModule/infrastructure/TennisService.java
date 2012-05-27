package infrastructure;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import domain.model.Game;
import domain.model.Match;
import domain.model.NormalGame;
import domain.model.NormalScore;
import domain.model.Player;
import domain.model.Score;
import domain.model.TennisSet;
import domain.model.Tournament;

@Stateless
public class TennisService implements TennisServiceRemote {
	
	@EJB
	private RepositoryTennis repo;
	
	public TennisService() {
		
	}

	public void play() {
		ArrayList<Player> lstPlayer = new ArrayList<Player>();
		for (int i = 0; i < 2; i++) {
			Player player = new Player("user" + Integer.toString(i));
			lstPlayer.add(player);
		}

		Tournament tournament = new Tournament(lstPlayer);
		
		tournament.play();

		repo.register(tournament);
	}

	public String f() {

		return "f()";
	}
	
	

}
