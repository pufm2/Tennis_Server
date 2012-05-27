import domain.model.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {

	TennisSet set;
	Player server, receiver;
	
	@Before
	public void setUp(){
		server = new Player();
		receiver = new Player();
		set = new TennisSet(server, receiver);
	}
	
	@Test
	public void testUpdateSetTable() {
		set.playSet();
	}	
}