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
     * @param n The board object.
     * @return Int indicating whether the outcome is positive or negative.
     */
	abstract public int e(Board n);

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

//        while (currentState != null){
//
//            // Creates a new state from the current state, sets it to current
//            State nextState = currentState.getNextState();
//
//            // Alpha beta pruning part
//            if (currentState.getValue() != null &&
//                    currentState.getNextColor().equals(minColor) &&
//                    currentState.getValue() < 0
//
//                    ){
//
//            }
//
//            if (nextState == null){
//                // This means that are are no more children left
//
//                // Checks the parent
//                if (currentState.getParent() == null){
//                    if (currentState.getValue() == null){
//                        // In this case, the tree has been exhausted and there are no possible moves.
//                        // Thus null is returned
//                        return null;
//                    } else {
//                        // Returns the move that results in the state.
//                        return currentState.getNextMove();
//                    }
//                } else {
//
//                    // Case where there are no children left for this state, goes up one
//                    currentState = currentState.getParent();
//                    currentDepth--;
//                    continue;
//                }
//
//            }
//
//            // Increments the depth
//            currentDepth++;
//
//            // If the currentDepth is at the evaluation depth, evaluate
//            if (currentDepth == depth){
//                // Sets the value of the state
//                nextState.setValue(e(nextState.getBoardState()));
//            }
//
//            if (nextState.getValue() != null){
//                // Pushes up the value to the parent
//                if (currentState.getValue() == null){
//                    // Case where parent has no value
//                    currentState.setValue(nextState.getValue());
//                } else if (currentState.getNextColor().equals(maxColor)){
//                    // Case where the parent is max
//                    if (nextState.getValue() > currentState.getValue()){
//                        // Only sets the parents value to the childs if it is better than what is already there
//                        currentState.setValue(nextState.getValue());
//                    }
//                } else {
//                    // Case where the parent is min
//                    if (nextState.getValue() < currentState.getValue()){
//                        // Only sets the parents value to the childs if it is worse than what is already there
//                        currentState.setValue(nextState.getValue());
//                    }
//                }
//
//                currentState = nextState;
//            }
//        }
	}

    /**
     * Alpha beta method, based on the course slides p.25 (slightly modified). Returns the
     * @param state
     * @param currentDepth
     * @param alpha
     * @param beta
     * @param maximizing
     * @return
     */
	private int alphabeta(State state, int currentDepth, int alpha, int beta, boolean maximizing){

        State nextState = state.getNextState();

        if (currentDepth == depth || nextState == null){
            if (state.getValue() == null){
                int eval = e(state.getBoardState());
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
                System.out.println(v);
                System.out.println(nextState.getBoardState().toString());

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
