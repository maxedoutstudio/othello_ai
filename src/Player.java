import java.util.Scanner;

/**
 * Created by Maksym on 11/15/2016.
 */
public abstract class Player {
	
	private String color;

	Player(){
		this.color = "W";
	}
	
	//constructor
	Player(Board.Square color) {
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
	
	//move
	public int[] move(int x, int y){
//		Scanner inputs = new Scanner(System.in);
//		String emptyEnter = inputs.nextLine();
//		System.out.println("Enter a  x-coordinate: ");
//		x = inputs.nextInt();
//		System.out.println("Enter a y-coordinate: ");
//		y = inputs.nextInt();
//
//		if(emptyEnter == ""){
//			return null;
//		}
		return new int[]{x,y};
	}
}

