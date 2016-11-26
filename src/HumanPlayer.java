import java.util.Scanner;

/**
 * Created by Maksym on 11/15/2016.
 */
public class HumanPlayer extends Player{
	private String color;
    //defaults constructor
	public HumanPlayer(){
    	this.color = "B";
    }
	
	//constructor
	HumanPlayer(Board.Square color) {
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
		
	//ask player to enter their move (x,y) coordinates
	public int[] move(int x, int y){
			Scanner inputs = new Scanner(System.in);
			String emptyEnter = inputs.nextLine();
			System.out.println("Enter a  x-coordinate: ");
			x = inputs.nextInt();
			System.out.println("Enter a y-coordinate: ");
			y = inputs.nextInt();

			if(emptyEnter == ""){
				return null;
			}
			return new int[]{x,y};
		}

}
