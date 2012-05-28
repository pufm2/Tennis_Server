package domain.model;

public class GameFactory {
	public static Game createGame(int player1Point, int player2Point, Player player1, Player player2) {
		
		if (((player1Point == 6 || player2Point == 6) && Math.abs(player1Point - player2Point) >= 2) ||
			(player1Point == 7 || player2Point == 7)) {
			return null;
		} else if (player1Point == 6 && player2Point == 6) {
			return new TieBreakGame(player1, player2);
		} else {
			return new NormalGame(player1, player2);
		}
	}
}
