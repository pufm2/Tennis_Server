package domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import utils.Utils;

@Entity
public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Match> matchs = new ArrayList<Match>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Player> players;

	public Tournament() {
	}

	public Tournament(List<Player> players) {
		this.players = players;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public void play() {

		List<Player> players = new ArrayList<Player>(this.players);
		List<Player> winners = new ArrayList<Player>();

		while (players.size() > 1) {
			int numOfPlayers = players.size();
			do {
				Player player1 = players.remove(Utils.getRandomNumber(numOfPlayers--));
				Player player2 = players.remove(Utils.getRandomNumber(numOfPlayers--));

				Match match = new Match(player1, player2);
				matchs.add(match);

				match.play();

				/*System.out.println(player1.getPlayerName() + "-" + player2.getPlayerName()
						+ ": " + match.getWinner().getPlayerName());*/

				if (player1.equals(match.getWinner())) {
					winners.add(player1);
				} else {
					winners.add(player2);
				}
			} while (numOfPlayers > 1);
			players.addAll(winners);
			winners.clear();
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}
}
