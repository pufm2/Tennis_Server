package infrastructure;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.model.Tournament;

@Stateless
public class RepositoryTennisJPA implements RepositoryTennis{

	@PersistenceContext(unitName="TennisPU")
	protected EntityManager em;

	public RepositoryTennisJPA(){

	}

	@Override
	public void register(Tournament tournament) {
		em.persist(tournament);
	}

	@Override
	/*
	 * Neu ham nay luon luon tra ve null => ghi nhan tat ca lan choi cua 1 player
	 */
	public Tournament recorverTournament(int id) {
//		if (playerName.equals(""))
//			return null;
//		else
//			return em.find(FizzBuzz.class, playerName); // ham find chi thao tac tren Primary key cua class
		return null;
	}
}