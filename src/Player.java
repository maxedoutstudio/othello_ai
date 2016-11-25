import java.util.Scanner;

/**
 * Created by Maksym on 11/15/2016.
 */
public abstract class Player {
	
	private String color;
	
	
	//constructor
	private Player(Board.Square color) {
		 this.color = color.getColor();
	}
	//get opponent
	public String getOpponent() {

		if(color == "B"){
			return "W" ;
		}
		else{return "B";}	
	}
	//return the color of the square
	public String color() {
		return color;
	}
	
//	//move
//	public int[] Move(int x, int y){
//		
//		return [xInput,yInput];
	}
}
