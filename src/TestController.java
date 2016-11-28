import java.util.Scanner;

/**
 * Created by Maksym on 11/25/2016.
 */
public class TestController {

    public static void main(String [] args) throws Exception{
     
    Scanner input  = new Scanner(System.in);
    System.out.println("Reversi - Othello");
    System.out.print("Please Enter '1' for PVP | Enter '2' for PVsAI | Enter '3' for AIVsAI -> ");
    
    int console_input = input.nextInt();  
    
    while (console_input != (1) && console_input != (2) && console_input != (3)){
    	
    	System.out.print("Please Enter '1' for PVP | Enter '2' for PVsAI | Enter '3' for AIVsAI -> ");    	    
    	   console_input = input.nextInt();  
    }    	
    
    if( console_input == 1){
    	System.out.println("\nPlayer vs Player");
    	Game pvp = new Game();
    	
        pvp.loop();

    }
    
    if( console_input == 2){
    	System.out.println("\nPlayer vs AI");
    	Game pvAI = new Game( "Human", "AI");
        pvAI.loop();
    }
    
    if( console_input == 3){
    	System.out.println("\nAI vs AI");
    	AIPlayer p1 = null;
    	AIPlayer p2 = null;
    	Game AIvAI = new Game("MAKSYM1 7", "MAKSYM1 2");
        AIvAI.loop();

    }
    
   	
/*        Board b = new Board();

        System.out.println(b);
        try{
            b.place(3, 2, "F");
            System.out.println(b);
            b.place(2, 4, "T");
            System.out.println(b);
            b.place(1, 5, "F");
            System.out.println(b);
            b.place(1, 4, "T");
            System.out.println(b);
            b.place(1, 3, "F");
            System.out.println(b);
            b.place(0, 2, "T");
            System.out.println(b);
        } catch (Exception e){
            throw e;
        }*/


    }
}
