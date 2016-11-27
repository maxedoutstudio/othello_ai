import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Maksym on 11/15/2016.
 */
public abstract class Player {
	
	protected String color;
    protected boolean skipping;
    protected Board board;
    protected int[] lastMove;
	Player(){
		this.color = "W";
        skipping = false;
	}
	
	//constructor
	Player(Board board, String color) {
		this.board = board;
        this.color = color;
        skipping = false;
	}

	//get opponent
	public String getOpponent() {

		if(color.equals("B")){
			return "W" ;
		}
		else{return "B";}	
	}
	//return the color of the square
	public String color() {
		return color;
	}

	public boolean getSkipping(){
        return skipping;
    }

    public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setSkipping(boolean skipping){this.skipping = skipping;}

	//move
	abstract public int[] move();
	//stores last move made by player

	public int[] getLastMove() {		
		return lastMove;
		}	
}

