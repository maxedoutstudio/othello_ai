
public class GameVsAi {

    private boolean playing;

    private Player p1;
    private Player p2;

    private Player currentPlayer;

    private Board board;

    GameVsAi(){
        p1 = new HumanPlayerConsole("B");
        p2 = new AIPlayer(null, "W"); //first parameter sets the search to use

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
            System.out.println(board);

            // Executes a turn
            turn();

            // Checks victory conditions
            Player p = checkVictory();

            if (p != null){
                // Victory occurs
                playing = false;
                System.out.println(p.color() + " player wins!!!");
            }

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

}