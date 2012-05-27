package domain.model;

import javax.persistence.Entity;

@Entity
public class NormalGame extends Game {

	private static final long serialVersionUID = -8150040459278706518L;

	public NormalGame(Player server, Player receiver){
		super(new NormalScore(), new NormalScore(), server, receiver);
	}
}
