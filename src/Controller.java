/**
 * Controller is the basic coordinator and communication means
 * from the game abstraction to the model manipulation.
 */
public final class Controller {

	/**
	 * false : if it the black player plays
	 * true  : if it the white player plays
	 */
	private Board board; //boar object
	private Player player; //player object
	public static final int DEFAULT_DEPTH = 3; //depth holder
	private static int depth = DEFAULT_DEPTH;
	// 0 = can move 1 = one can't move 2 = none can move
	private final short CANMOVE = 0, CANNOTMOVE = 2;
	private short canMove = CANMOVE;

	//controller for board
	private Controller() {
		this.board = new Board();
		init();
	}

	//get and mark all the possible moves for a player
	public Set markPossibleMoves() {
		Set moves = board.getPossibleMoves(player); //get possible moves for a player
		board.markPossibleMoves(moves); //set possible moves
		canMove = moves.isEmpty() ? ++canMove : CANMOVE;
		return moves;
	}
	//unmark possible moves on the board
	public void unmarkPossibleMoves() {
		board.unmarkPossibleMoves();
	}
	//set the move on the board with player's color
	public Set makeMove(move) {
		return board.makeMove(move, player.color());
	}
	//calculate score based on the state of the board
	private int calcScore(Square state) {
		return board.count(state);
	}
	//calculate black chips
	public int getBlackScore() {
		return board.count(Square.BLACK);
	}
	//calculate white chips
	public int getWhiteScore() {
		return board.count(Square.WHITE);
	}
	//determine winner with most chips
	public Player getWinner() {
		return getBlackScore() < getWhiteScore() ? Player.WHITE : Player.BLACK;
	}
	//if there is a draw
	public boolean isDraw() {
		return getBlackScore() == getWhiteScore();
	}

	//return end of game condition -> board is full, a player's score is zero, no one has a valid next move
	public boolean endOfGame() {
		return board.isFull() || checkZeroScore() || canMove == CANNOTMOVE;
	}
	// check if black or white haver hit 0
	private boolean checkZeroScore() {
		return getBlackScore() == 0 || getWhiteScore() == 0;
	}
	//change turns
	public void changeTurn() {
		player = player.opponent();
	}
	//set current player
	public Player currentPlayer() {
		return player;
	}
	//set the board for correct player
	public String boardWithTurn() {
		return board.toStringWithStatsTurn(player);
	}
	//starting codintion
	public void init() {
		board.init();
		player = Player.BLACK;
		canMove = CANMOVE;
	}
	
}
