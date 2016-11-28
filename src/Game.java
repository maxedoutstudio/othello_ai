import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Maksym on 11/15/2016.
 */

public class Game {

    //Player related stuff
    private Player p1;
    private Player p2;
    private Player currentPlayer;

    //Board stuff
    private Board board;
    private String boardType;
    private String file_name;
    private int[] lastMove;
    private boolean playing;

    // Turn timer stuff
    static final private int DEFAULT_TIME_LIMIT = 30000;


    Game() {
        board = new Board();

        playing = true;

        p1 = new HumanPlayerConsole(board, "B", 30000);
        p2 = new HumanPlayerConsole(board, "W", 30000);

        currentPlayer = p1;

    }

    Game(String player1, String player2, String boardType){
        board = new Board();

        playing = true;

        if (player1.contains("Human")){
            String[] parts = player1.split(" ");
            if(parts == null || parts.length != 2){
                parts = new String[]{"Human", "30"};
            }
            int time = Integer.parseInt(parts[1]) * 1000;
            p1 = new HumanPlayerConsole(board, "B", time);
        } else {
            String[] parts = player1.split(" ");

            if(parts == null || parts.length != 2){
                parts = new String[]{"GREEDY", "1"};
            }

            int d = Integer.parseInt(parts[1]);

            p1 = new AIPlayer(parts[0], board, "B", d);
        }

        if (player2.contains("Human")){
            String[] parts = player2.split(" ");
            if(parts == null || parts.length != 2){
                parts = new String[]{"Human", "30"};
            }
            int time = Integer.parseInt(parts[1]) * 1000;
            p2 = new HumanPlayerConsole(board, "W", time);
        } else {
            String[] parts = player2.split(" ");

            if(parts == null || parts.length != 2){
                parts = new String[]{"GREEDY", "1"};
            }

            int d = Integer.parseInt(parts[1]);

            p2 = new AIPlayer(parts[0], board, "W", d);
        }

        currentPlayer = p1;
    }

    
    /**
     * Main game logic loop.
     */
    public void loop(){
    	
    	//logs initial board position
    	save(outputStart());
    	
        while(playing){
        	
            // Prints the game board
            System.out.println("\n" +board);

            // Runs the turn
            turn();

            // Checks victory conditions
            Player p = checkVictory();

            if (p != null){
                // Victory occurs
                playing = false;
                System.out.println("\n" + board);
                System.out.println(p.color() + " player wins!!!");
            }

            // If null due to draw
            if (p == null && p1.getSkipping() && p2.getSkipping()){
                playing = false;
                System.out.println("Draw!!!");
            }
            
        }
        
    }

    /**
     * Executes the turn for both players. Returns true when successful.
     */
    private void turn(){

    	// Gets the move from the player
        int[] move;
        String col;

        move = currentPlayer.move();
        col = currentPlayer.color();

        if(move != null){
            try{
                // Attempts to place the move
                board.place(move[0], move[1], col);
                lastMove = currentPlayer.getLastMove();
                //logs initial board position
            	save(outputStart());
                // Changes the game turn
                currentPlayer = currentPlayer==p1 ? p2: p1;
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            if (currentPlayer.getSkipping()){
                // Changes the game turn
            	lastMove = currentPlayer.getLastMove();
                currentPlayer = currentPlayer==p1 ? p2: p1;
            }
        }

    }

    /**
     * Checks the victory conditions.
     * @return Which player has one (true for player1, false for player2, null for neither).
     */
    private Player checkVictory(){
        boolean gameEnd = false;

        if (board.isFull()){
            // Checks for condition where player has no pieces left
            gameEnd = true;
        } else if (board.count("W") == 0){
            gameEnd = true;
        } else if (board.count("B") == 0){
            gameEnd = true;
        } else if (p1.getSkipping() && p2.getSkipping()){
            gameEnd = true;
        }

        if (gameEnd){
            Player winningPlayer;

            String p1Color = p1.color();
            String p2Color = p2.color();

            int p1Score = board.count(p1Color);
            int p2Score = board.count(p2Color);

            if (p1Score > p2Score){
                return p1;
            } if (p2Score < p1Score){
                return p2;
            } else {
                return null;
            }
        }
        return null;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    //write to file
    public void save (String output) {
    	
    	try{
    	    output = "Log";	
    	    BufferedWriter out = new BufferedWriter(new FileWriter(output+".txt",true));
    	    out.write(outputStart());
    	    out.newLine();
    	    //out.flush();
    	    out.close();    	    	
    	}catch (IOException e) {
    		System.out.println("Unable to write to file");
    	}
    }      
    public void load (){
    	
    }
    
    public String outputStart(){
    	if(lastMove != null){
        	return  ("Current Player: " + currentPlayer.color() + " " + "Board: " + board.toStringOutPutFile() + " Player Move: " + Arrays.toString(lastMove));

    	}    	    	
    	else{
    		return  "Board: " + board.toStringOutPutFile();	
    	}    
    }
    
   
}   
