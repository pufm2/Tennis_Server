package application;

import infrastructure.RepositoryTennis;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TennisService implements TennisRemote {

	@EJB
	private RepositoryTennis repository;

	public void play(){


	}
}
