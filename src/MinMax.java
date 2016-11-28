import java.util.ArrayList;
import java.util.Arrays;

public abstract class MinMax {

	//variables
	private Board board;
	private int depth;

	//Color that the algorithm will try to maximize for
	protected String maxColor;
	protected String minColor;

    //Finals for alphabeta
    static final public int MAX_INT = 2147483647;
    static final public int MIN_INT = -2147483648;

	MinMax(){} //default constructor
	MinMax(Board board, int depth, String maxColor){

		this.board = board;
		this.depth = depth;
		this.maxColor = maxColor;

		if (maxColor.equals("W")){
			this.minColor = "B";
		} else {
			this.minColor = "W";
		}
	}

    /**
     * Abstract evaluation function, returning negative number if the outcome is good for min, + if good for max, 0 if
     * neutral result.
     * @param n The board State object.
     * @return Int indicating whether the outcome is positive or negative.
     */
	abstract public int e(State n);

    /**
     * Gets the move the AI should take. Implements MiniMax using Alpha-Beta pruning techniques.
     * @return The move the algorithm chooses to take.
     */
	public int[] getMove(){

        State currentState = new State(board, null, minColor, null);

        // Calls the recursive alpha beta algorithm, which takes the current state
        int heuristicValue = alphabeta(currentState, 0, MIN_INT, MAX_INT, true );

        // Gets the move to make from the recursive alpha beta algorithm
        int[] move = currentState.getNextMove();

        System.out.println(heuristicValue);
        System.out.println("MOVE: " + Arrays.toString(move));

        // Returns the move to make
        return move;

	}

    /**
     * Alpha beta method, based on the course slides p.25 (slightly modified). Returns the
     * @param state The state of the board.
     * @param currentDepth The current depth of the algorithm.
     * @param alpha The alpha variable.
     * @param beta The beta variable.
     * @param maximizing Whether the algorithm is calculating max or min.
     * @return The heuristic value of the chosen move. The chosen move itself is added to the given state.
     */
	private int alphabeta(State state, int currentDepth, int alpha, int beta, boolean maximizing){

        State nextState = state.getNextState();

        if (currentDepth == depth || nextState == null){
            if (state.getValue() == null){
                int eval = e(state);
                state.setValue(eval);
                return eval;
            } else {
                return state.getValue();
            }
        }
        if (maximizing){
            int v = MIN_INT;
            while(nextState != null){
                int oldV = v;

                // Sets the value to the max of its children
                v = Math.max(v, alphabeta(nextState, currentDepth + 1, alpha, beta, false));

                if (v!= oldV){
                    // Means that the value change, used to keep track of what move should be made
                    state.setNextMove(nextState.getMove());
                }

                alpha = Math.max(alpha, v);
                if (beta <= alpha){
                    break; // Beta cut-off point
                }
                nextState = state.getNextState();
            }
            return v;
        } else {
            int v = MAX_INT;
            while(nextState != null){
                int oldV = v;

                // Sets the value to the min of its children
                v = Math.min(v, alphabeta(nextState, currentDepth + 1, alpha, beta, true));

                if (v!= oldV){
                    // Means that the value change, used to keep track of what move should be made
                    state.setNextMove(nextState.getMove());
                }
                beta = Math.min(beta, v);
                if (beta <= alpha){
                    break; // Alpha cut-off point
                }
                nextState = state.getNextState();
            }
            return v;
        }
    }


}
