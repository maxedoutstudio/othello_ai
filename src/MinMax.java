import java.util.ArrayList;

public abstract class MinMax {

	//variables
	private Board board;
	private int depth;

	//Color that the algorithm will try to maximize for
	protected String maxColor;
	protected String minColor;

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
        int currentDepth = 0;

        while (currentState != null){

            // Creates a new state from the current state, sets it to current
            State nextState = currentState.getNextState();

            if (nextState == null){
                // Checks the parent
                if (currentState.getParent() == null){
                    // In this case, there are no possible moves, so return null
                    return null;
                }

                // Case where there are no children left for this state, goes up one
                currentState = currentState.getParent();
                currentDepth--;
                continue;
            }

            // Increments the depth
            currentDepth++;

            // If the currentDepth is at the evaluation depth, evaluate
            if (currentDepth == depth){
                // Sets the value of the state
                nextState.setValue(e(nextState.getBoardState()));
            } else {

            }

            if (currentState.getValue() != null){

                // Pushes up the value to the parent
                State parent = currentState.getParent();
                if (parent.getValue() == null){
                    // Case where parent has no value
                    parent.setValue(currentState.getValue());
                } else if (parent.getNextColor().equals(maxColor)){
                    // Case where the parent is max
                    if (currentState.getValue() > parent.getValue()){
                        // Only sets the parents value to the childs if it is better than what is already there
                        parent.setValue(currentState.getValue());
                    }
                } else {
                    // Case where the parent is min
                    if (currentState.getValue() < parent.getValue()){
                        // Only sets the parents value to the childs if it is worse than what is already there
                        parent.setValue(currentState.getValue());
                    }
                }

                currentDepth--;
                currentState = parent;
            }
        }




        ArrayList<ArrayList<State>> tree = new ArrayList<>();

		//generate tree for all states depending on depth
		for(int i = -1; i<depth-1; i++){
			if (tree.isEmpty()){
				ArrayList<State> states = board.getPossibleStates(maxColor);
				tree.add(states);
			} else {
				ArrayList<State> lvl = tree.get(i);
				ArrayList<State> states = new ArrayList<>();

				for (int j = 0; j < lvl.size(); j++){
					if (i % 2 == 0){
						// Occurs on min lvl
						states.addAll(lvl.get(j).getBoardState().getPossibleStates(minColor));
					} else {
						// Occurs on max lvl
						states.addAll(lvl.get(j).getBoardState().getPossibleStates(maxColor));
					}
				}
				tree.add(states);
			}
		}

		//start from last layer loop upwards
		for(int i = tree.size()-1; i>=0; i--){

			//loop inner
			for(int j=0; j<tree.get(i).size(); j++){

				//Runs the evaluation function for the state
				tree.get(i).get(j).setValue(e(tree.get(i).get(j).getBoardState()));
			}
		}
		return new int[]{x,y};
	}


}
