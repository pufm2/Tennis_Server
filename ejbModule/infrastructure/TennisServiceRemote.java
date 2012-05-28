package infrastructure;

import javax.ejb.Remote;

@Remote
public interface TennisServiceRemote {
	public String play(int numberOfPlayer);
	public String getTournament(int id);
}
