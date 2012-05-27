package infrastructure;

import javax.ejb.Local;

import domain.model.Tournament;


@Local
public interface RepositoryTennis {
	public void register(Object object);
	public Tournament recorverTournament(int id);
}
