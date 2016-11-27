import java.util.Scanner;

/**
 * Created by Maksym on 11/15/2016.
 */
public class HumanPlayerConsole extends Player{

	HumanPlayerConsole(){
		super();
	}

	HumanPlayerConsole(Board board, String color){
		super(board,color);
		
	}

	//ask player to enter their move (x,y) coordinates
	
	public int[] move(){
			int x=-1,y=-1;

			skipping = false;
			System.out.println("Player: " + color);
			Scanner inputs = new Scanner(System.in);
			
			System.out.print("Enter a  x-coordinate: ");
			String string_x = inputs.nextLine();
			
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
			lastMove = new int[]{x,y};
			return new int[]{x,y};
		}

}
