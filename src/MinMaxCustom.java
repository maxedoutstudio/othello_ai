/**
 * Custom MinMax that can use alternative heuristics.
 */
public class MinMaxCustom extends MinMax {

    private static final float WEIGHT_1 = 0.25f;
    private static final float WEIGHT_2 = 0.50f;
    private static final float WEIGHT_3 = 0.15f;
    private static final float WEIGHT_4 = 0.50f;

	MinMaxCustom(){super();}
	MinMaxCustom(Board board, int depth, String maxColor){
		super(board, depth, maxColor);
	}

	@Override
	public int e(State n) {

		// Sample file for building your own heuristics
		Board b = n.getBoardState();

		// The string version of the board
		String boardString = b.toStringOutPutFile(); // Formatted board into string

		// The move that resulted in this board state
		int[] move = n.getMove();

		// The player whose turn it is
		String p = n.getNextColor();

        return 0;
	}
}
