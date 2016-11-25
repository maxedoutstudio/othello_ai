/**
 * Created by Maksym on 11/15/2016.
 */

public class Game {

    private boolean turn;

    private Player p1;
    private Player p2;

    private Board board;

    public Game(){

        p1 = new HumanPlayer();
        p2 = new HumanPlayer();

        board = new Board();

    }

    /**
     * Executes the turn for both players.
     */
    public void turn(){

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
