import java.util.Scanner;

/**
 * Created by Maksym on 11/15/2016.
 */
public class HumanPlayerConsole extends Player{
	
	//default constructor
	HumanPlayerConsole(){
		super();
	}
	//constructor passes a board and color
	HumanPlayerConsole(Board board, String color){
		super(board,color);
	}
	//ask player to enter their move (x,y) coordinates
	public int[] move(){
			int x=-1,y=-1;//Initial input
			skipping = false; //no skip turn
			//ask human player to enter x and y co-ords
			System.out.println("Player: " + color);
			Scanner inputs = new Scanner(System.in);			
			System.out.print("Enter a  x-coordinate: ");
			String string_x = inputs.nextLine();
			//convert string console input to interger values
			try{
				x = Integer.parseInt(string_x);
			}
			catch(Exception e){
                if (!string_x.equals("")){
                    return null;
                }
			}			
			System.out.print("Enter a  y-coordinate: ");
			String string_y = inputs.nextLine();
			
			try{
				y = Integer.parseInt(string_y);
			}
			catch(Exception e){

                if (string_x.equals("") && string_y.equals("")){
                    skipping = true;
                }
				return null;
			}
			//stores the last move of player
			lastMove = new int[]{x,y};
			return new int[]{x,y};
		}
}
