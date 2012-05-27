package infrastructure;

import javax.ejb.Local;

import domain.model.Tournament;

@Local
public interface RepositoryTennis {
	public void register(Tournament tennis);
	public Tournament recorverTournament(int id);
}
