package gamestates;

import boardComponents.Board;
import boardComponents.MatrixPair;
import gui.GameBoard;
import players.Player;

public class GameInstance {
	
	public GameBoard gameBoard;
	public Board board;
	public String numberOfPlayers;
	public String typesOfPlayers;
	public String gameSelected;
	private Player[] playerArray;
	private boolean gameDone;
	
	
	//makes the type of game board depending on the game you selected
	public GameInstance(String gameSelected, String nop, String top) {
		board = new Board(gameSelected);
		numberOfPlayers = nop;
		typesOfPlayers = top;
		this.gameSelected = gameSelected;
		startGameInstance();
	}
	
	public void startGameInstance() {
		createPlayers();
		gameBoard = new GameBoard(numberOfPlayers, board);
		Thread gbThread = new Thread(gameBoard);
		gbThread.start();
		gamePlay();
	}
	
	//creates the type of players needed
	public void createPlayers() {
		if(numberOfPlayers.equals("Two")) {
			if(typesOfPlayers.equals("Human vs Human")) {
				playerArray = new Player[] {new Player(1, true), new Player(2, true)};
			}else if(typesOfPlayers.equals("Human vs AI")) {
				playerArray = new Player[] {new Player(1, true), new Player(2, false)};
			}
		}else if(numberOfPlayers.equals("Three")) {
			if(typesOfPlayers.equals("Human vs Human vs Human")) {
				playerArray = new Player[] {new Player(1, true), new Player(2, true), new Player(3, true)};
			}else if(typesOfPlayers.equals("Human vs Human vs AI")) {
				playerArray = new Player[] {new Player(1, true), new Player(2, true), new Player(3, false)};
			}else if(typesOfPlayers.equals("Human vs AI vs AI")) {
				playerArray = new Player[] {new Player(1, true), new Player(2, false), new Player(3, false)};
			}
		}else if(numberOfPlayers.equals("Four")) {
			if(typesOfPlayers.equals("Two Humans vs Two Humans")) {
				playerArray = new Player[] {new Player(1, true), new Player(2, true), new Player(3,true), new Player(4, true)};
			}else if(typesOfPlayers.equals("Two Humans vs Two AI")) {
				playerArray = new Player[] {new Player(1, true), new Player(2, true), new Player(3, false), new Player(4, false)};
			}
		}
	}
	
	//cycle of the game play for each player
	public void gamePlay() {
		int playerTurn = 0;
		CheckMove moveCheck = new CheckMove(board);
		int roll = 0;
		MatrixPair[] possMP;
		Player currentPlayer;
		roll = 6;
		
		//game loop
		do {
			currentPlayer = playerArray[playerTurn];
			gameBoard.setRollButton();
			while(roll == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(gameSelected.equals("Dice")) {
				if(roll == 10) {
					possMP = moveCheck.checkDiceMovesTen(currentPlayer.getPlayerID());
					gameBoard.updatePossibleMoves(possMP);
				}else if(roll == 11) {
					possMP = moveCheck.checkDiceMovesEleven(currentPlayer.getPlayerID());
					gameBoard.updatePossibleMoves(possMP);
				}else {
					possMP = moveCheck.checkDiceMoves(roll);
					gameBoard.updatePossibleMoves(possMP);
				}
			}
			if(playerTurn < playerArray.length - 1) {
				playerTurn++;
			}else {
				playerTurn = 0;
			}
			roll = 0;
		}while(gameDone == false);
	}
}