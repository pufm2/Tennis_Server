package infrastructure;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RepositoryTennisJPA implements RepositoryTennis {

	@PersistenceContext(unitName="TennisPU")
	protected EntityManager em;

	public RepositoryTennisJPA(){

	}

	public void persist(Object object) {
		em.persist(object);
	}

	public <T> T find(Class<T> clazz, int id) {
		return em.find(clazz, id);
	}
}