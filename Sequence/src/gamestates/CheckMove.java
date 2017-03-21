package gamestates;

import java.util.ArrayList;

import boardComponents.Board;
import boardComponents.MatrixPair;

public class CheckMove {
	
	public Board board;
	
	public CheckMove(Board board) {
		this.board = board;
	}
	
	/*
	 * Param: roll = the number rolled by the current player
	 * Return: returns an array of MatrixPairs of the possible moves that can be made by the current player
	 */
	public MatrixPair[] checkDiceMoves(int roll) {
		MatrixPair[] mp = new MatrixPair[4];
		int mpPos = 0;
		
		for(int i = 0; i < board.getSizeOfBoard(); i++) {
			for(int j = 0; j < board.getSizeOfBoard(); j++) {
				int numInSqu = board.numContainedInSquare(i, j);
				
				if(numInSqu == roll) {
					mp[mpPos] = new MatrixPair(i, j);
					mpPos++;
				}
			}
		}
	
		return mp;
	}
	
	/*
	 * Param: playerId = the current player that rolled the ten
	 * Return: returns the array of MatrixPairs that is possible for the player to remove
	 */
	public MatrixPair[] checkDiceMovesTen(int playerID) {
		ArrayList<MatrixPair> mpList = new ArrayList<MatrixPair>(); //to hold the MatrixPairs to put in a normal array later without going through more than once
		for(int i = 0; i < board.getSizeOfBoard(); i++) {
			for(int j = 0; j < board.getSizeOfBoard(); j++) {
				
				//Checks to see if the square is taken, then if it isn't owned by the player rolling, then if the square number is 2 or 12
				if(board.isSqaureTaken(i, j) == true) {
					if(board.playerIDInSqaure(i, j) != playerID) {
						if(board.numContainedInSquare(i, j) != 2 && board.numContainedInSquare(i, j) != 12) {
							mpList.add(new MatrixPair(i, j));
						}
					}
				}
				
			}
		}
		MatrixPair[] mpMoves = new MatrixPair[mpList.size()];
		for(int k = 0; k < mpList.size(); k++) {
			mpMoves[k] = mpList.get(k);
		}
		
		return mpMoves;
	}
	
	public MatrixPair[] checkDiceMovesEleven(int playerID) {
		ArrayList<MatrixPair> mpList = new ArrayList<MatrixPair>();
		for(int i = 0; i < board.getSizeOfBoard(); i++) {
			for(int j = 0; j < board.getSizeOfBoard(); j++) {
				if(board.isSqaureTaken(i, j) == false) {
					mpList.add(new MatrixPair(i, j));
				}
			}
		}
		
		//if all the pieces are taken, sets all the pieces that are not yours
		if(mpList.isEmpty()) {
			for(int i = 0; i < board.getSizeOfBoard(); i ++) {
				for(int j = 0; j < board.getSizeOfBoard(); j++) {
					
				}
			}
		}
		
		MatrixPair[] mpMoves = new MatrixPair[mpList.size()];
		for(int k = 0; k < mpList.size(); k++) {
			mpMoves[k] = mpList.get(k);
		}
		
		return mpMoves;
	}
	
}