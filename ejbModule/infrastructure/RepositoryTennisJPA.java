package infrastructure;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.model.Tournament;

@Stateless
public class RepositoryTennisJPA implements RepositoryTennis {

	@PersistenceContext(unitName="TennisPU")
	protected EntityManager em;

	public RepositoryTennisJPA(){

	}

	public void register(Object object) {
		em.persist(object);
		//em.flush();
	}

	public Tournament recorverTournament(int id) {

		return em.find(Tournament.class, id);
	}
}