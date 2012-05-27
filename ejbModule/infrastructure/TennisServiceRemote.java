package infrastructure;

import javax.ejb.Remote;

@Remote
public interface TennisServiceRemote {
	public void play();
	public String f();
}
