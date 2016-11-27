import java.io.*;

/**
 * Created by Maksym on 11/15/2016.
 */

public class Game {
	
    private boolean playing;

    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Board board;
    private String file_name;
        
    Game() {
        p1 = new HumanPlayerConsole(board, "B");
        p2 = new HumanPlayerConsole(board, "W");

        board = new Board();

        playing = true;
        currentPlayer = p1;
    }
    Game(HumanPlayerConsole p1, AIPlayer p2){
    	
    	  p1 = new HumanPlayerConsole(board,"B");
          p2 = new AIPlayer(null, board, "W"); //first parameter sets the search to use

          board = new Board();

          playing = true;
          currentPlayer = p1;
    }
    
    /**
     * Main game logic loop.
     */
    public void loop(){

        while(playing){

            // Prints the game board
            System.out.println("\n" +board);

            // Executes a turn
            turn();

            // Checks victory conditions
            Player p = checkVictory();

            if (p != null){
                // Victory occurs
                playing = false;
                System.out.println("\n" + board);
                System.out.println(p.color() + " player wins!!!");
            }
            save(output());
        }
        
    }

    /**
     * Executes the turn for both players.
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

                // Changes the game turn
                currentPlayer = currentPlayer==p1 ? p2: p1;
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            if (currentPlayer.getSkipping()){
                // Changes the game turn
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
            } else {
                return p2;
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
    	output = "file";	
    	BufferedWriter out = new BufferedWriter(new FileWriter(output+".txt",true));
    	out.write(output());
    	out.newLine();
    	out.flush();
    	out.close();
    	} catch (IOException e) {
    		System.out.println("Unable to write to file");
    	}
//    	finally{
//    	    if(out != null){
//    	        out.close();
//    	    }
//    	}
    }
        
    public void load (){
    	
    }
    
    public String output(){
    	
    	return  "Current Player: " + currentPlayer.color() + " " + "Board: " + board.toStringOutPutFile();	
    	//return  "Current Player: " + currentPlayer.color() + " " + "Board: " + board.toStringOutPutFile() + "Player Move: " + String.valueOf(currentPlayer.move());
    }
   
}
