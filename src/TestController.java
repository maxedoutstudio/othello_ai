import java.util.Scanner;

/**
 * Created by Maksym on 11/25/2016.
 */
public class TestController {

    public static void main(String [] args) throws Exception{
     
    Scanner input  = new Scanner(System.in);
    System.out.println("Reversi - Othello");
    System.out.println("Enter '1' for PVP | Enter '2' for PVAI");
    
    int console_input = input.nextInt();  
    
    if( console_input == 1){
    	
    	Game pvp = new Game();
        pvp.loop();

    }
    
    if( console_input == 2){
    	
    	GameVsAi pvAI = new GameVsAi();
        pvAI.loop();

    }    	   	
    	
//        Board b = new Board();
//
//        System.out.println(b);
//        try{
//            b.place(3, 2, "F");
//            System.out.println(b);
//            b.place(2, 4, "T");
//            System.out.println(b);
//            b.place(1, 5, "F");
//            System.out.println(b);
//            b.place(1, 4, "T");
//            System.out.println(b);
//            b.place(1, 3, "F");
//            System.out.println(b);
//            b.place(0, 2, "T");
//            System.out.println(b);
//        } catch (Exception e){
//            throw e;
//        }


    }
}
