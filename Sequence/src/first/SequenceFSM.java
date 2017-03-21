package first;

import gui.MainMenu;
import gui.GameSelect;

import java.awt.event.WindowEvent;

import gamestates.GameInstance;


public class SequenceFSM {

	private MainMenu mainMenuFrame;
	private GameSelect gameSelectFrame;
	
	public void startMenu(SequenceFSM sFSM) {
		mainMenuFrame = new MainMenu(sFSM);
	}
	
	public void exitMenu() {
		System.out.println("Made it Here");
		
	}
	
	public void startGameSelect(SequenceFSM sFSM) {
		gameSelectFrame = new GameSelect(sFSM);
	}
	
	public void beginNewGame(String gameSelected, String nop, String top) {
		GameInstance gi =  new GameInstance(gameSelected, nop, top);
	}
}
