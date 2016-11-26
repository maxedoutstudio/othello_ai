/**
 * Created by Maksym on 11/15/2016.
 */

public class Game {

    private boolean turn;
    private boolean playing;

    private boolean p1Skip;
    private boolean p2Skip;

    private Player p1;
    private Player p2;

    private Board board;

    Game(){
        p1 = new HumanPlayer();
        p2 = new HumanPlayer();

        p1Skip = false;
        p2Skip = false;

        board = new Board();

        playing = true;
        turn = true;
    }

    /**
     * Main game logic loop.
     */
    public void loop(){

        while(playing){

            // Executes a turn
            turn();

            // Checks victory conditions
            Player p = checkVictory();

            if (p != null){
                playing = false;
                System.out.println(p.color() " player wins!!!");
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

        if (turn){
            move = p1.move();
            col = p1.color();
            p1Skip = false;
        } else {
            move = p2.moe();
            col = p1.color();
            p2Skip = false;
        }

        if(move != null){
            try{
                // Attempts to place the move
                board.place(move[0], move[1], col);

                // Changes the game turn
                turn = !turn;
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            if (turn){
                p1Skip = true;
            } else {
                p2Skip = false;
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
        } else if (p1Skip || p2Skip){
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
