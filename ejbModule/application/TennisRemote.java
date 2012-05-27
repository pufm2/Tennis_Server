package application;

import javax.ejb.Remote;

@Remote
public interface TennisRemote {
	public void play();
}
