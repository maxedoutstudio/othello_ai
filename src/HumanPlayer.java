import java.util.Scanner;

/**
 * Created by Maksym on 11/15/2016.
 */
public class HumanPlayer extends Player{

	HumanPlayer(){
		super();
	}

	HumanPlayer(String color){
		super(color);
	}

	//ask player to enter their move (x,y) coordinates
	public int[] move(){
			skipping = false;
			System.out.println("Player: " + color);
			Scanner inputs = new Scanner(System.in);
//			String emptyEnter = inputs.nextLine();
			System.out.println("Enter a  x-coordinate: ");
			int x = inputs.nextInt();
			System.out.println("Enter a y-coordinate: ");
			int y = inputs.nextInt();

//			if(emptyEnter.equals("")){
		//		skipping = true;
//				return null;
//			}
			return new int[]{x,y};
		}

}
