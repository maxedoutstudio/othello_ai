import java.util.Scanner;

/**
 * Created by Maksym on 11/25/2016.
 */
public class TestController {

    public static void main(String [] args) throws Exception{
     
    Scanner input  = new Scanner(System.in);
    String console_input1 = null, console_input2 = null, console_input3 = null;
    System.out.println("Reversi - Othello\n");
    
	    System.out.println("Player: Human	AI Search: GREEDY 	AI Search: MAKSYM1	AI Search: MAKSYM2	AI Search: MOH1	AI Search: MOH2");
	    System.out.println("\nIf you want p1/p2 to be a human player, Please Enter Human");
	    System.out.println("\nIf you want p1/p2 to be an AI, Please Enter name of Search followed by its Depth");
	    System.out.print("\nPlease Enter the type of Player for p1 -> ");
	    console_input1 = input.nextLine();
	    System.out.print("\nPlease Enter the type of Player for p2 -> ");
	    console_input2 = input.nextLine();
	    System.out.println("\nOutput of Board 8x8 Enter: BOARD");
	    System.out.println("Output of Board One Line Enter: LINE");
	    console_input3 = input.next();
    
	    
    //Passing player selection to class Game
    Game Othello = new Game(console_input1, console_input2, console_input3);
    Othello.loop();
    }
}
