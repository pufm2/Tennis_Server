package infrastructure;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import domain.model.Match;
import domain.model.Player;
import domain.model.TennisSet;
import domain.model.Tournament;

@Stateless
public class TennisService implements TennisServiceRemote {
	
	@EJB
	private RepositoryTennis repo;
	
	public TennisService() {
		
	}

	public String play(int numberOfPlayer) {
		ArrayList<Player> lstPlayer = new ArrayList<Player>();
		for (int i = 0; i < numberOfPlayer; i++) {
			Player player = new Player("player" + Integer.toString(i));
			lstPlayer.add(player);
		}

		Tournament tournament = new Tournament(lstPlayer);
		
		tournament.play();
		
		repo.persist(tournament);
		return toString(tournament);
	}

	public String getTournament(int id) {

		Tournament tournament = repo.find(Tournament.class, id);
		return toString(tournament);
	}
	
	private String toString(Tournament tournament) {
		String result = "";
		if (tournament == null) {
			return result;
		}
		for (Match match : tournament.getMatchs()) {
			result += match.getPlayer1().getPlayerName() + "-" + match.getPlayer2().getPlayerName() + " : " +
					match.getPlayer1SetWon() +  "-" + match.getPlayer2SetWon();
			int i = 1;
			for (TennisSet set : match.getLstSet()) {
				result += "\n    set " + i + " : " + set.getPointOfPlayer1() + "-" + set.getPointOfPlayer2();
				i++;
			}
			result += "\n";
		}
		result += "THE CHAMPION IS : " + tournament.getWinner();
		return result;
	}

}
