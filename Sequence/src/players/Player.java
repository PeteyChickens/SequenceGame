package players;

import boardComponents.MatrixPair;
import gamestates.GameInstance;

public class Player {
	
	private int playerID;
	private boolean isHuman;
	private AI ai;
	
	public Player(int playerID, boolean isHuman) {
		this.playerID = playerID;
		this.isHuman = isHuman;
		if(isHuman == false) {
			ai = new AI();
		}
	}
	
	public int getPlayerID() {
		return playerID;
	}
}