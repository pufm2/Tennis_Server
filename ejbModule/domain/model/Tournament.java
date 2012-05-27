package domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Match> matchs = new ArrayList<Match>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Player> players;

	public Tournament(List<Player> players) {
		this.players = players;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public void play() {

		List<Player> winners = new ArrayList<Player>();
		winners.addAll(players);

		int index = 0;

		List<Player> losers = new ArrayList<Player>();
		while (winners.size() > 1) {
			while (index < winners.size() - 1) {
				Player player1 = winners.get(index++);
				Player player2 = winners.get(index++);
				Match match = new Match(player1, player2);
				matchs.add(match);
				match.play();
				System.out.println(player1.getPlayerName() + "-" + player2.getPlayerName()
						+ ": " + match.getWinner().getPlayerName());

				if (player1.equals(match.getWinner())) {
					losers.add(player2);
				} else {
					losers.add(player1);
				}
			}
			
			winners.removeAll(losers);
			losers.clear();
			index = 0;
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
