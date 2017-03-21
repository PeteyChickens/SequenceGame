package boardComponents;

public class Square {
	
	private int numContained;
	private boolean taken;
	private int takenByPlayer;
	
	public Square(int numContained, boolean taken) {
		this.numContained = numContained;
		this.taken = taken;
	}
	
	public int getNumContained() {
		return this.numContained;
	}
	
	public void changeTaken(boolean taken) {
		this.taken = taken;
	}
	
	public boolean isTaken() {
		return this.taken;
	}
	
	public void squareTakenBy(int playerID) {
		takenByPlayer = playerID;
	}
	
	public int getPlayerID() {
		return takenByPlayer;
	}

}
