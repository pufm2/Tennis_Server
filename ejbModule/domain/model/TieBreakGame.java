package domain.model;

import javax.persistence.Entity;

@Entity
public class TieBreakGame extends Game {

	private static final long serialVersionUID = 5947004730323186498L;

	public TieBreakGame(Player server, Player receiver) {
		super(new TieBreakScore(), new TieBreakScore(), server, receiver);
	}
}
