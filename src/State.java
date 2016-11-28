import java.util.ArrayList;

public class State {

	private Board boardState;

	private int[] move; // The move that resulted in this state
    private int[] nextMove;

    private String color; // The color of the move that resulted in this state
    private String nextColor; // The color of the next move

	private Integer value;

	private State parent;

    // Helper variable for getNextState (used for DFS)
	private int[] lastChecked;

    State(State other){
        this.boardState = new Board(other.getBoardState());
        if(other.move != null){
            this.move = new int[]{other.move[0], other.move[1]};
        } else {
            this.move = null;
        }
        this.nextMove = other.nextMove;
        this.color = other.color;
        this.nextColor = other.nextColor;
        this.value = other.value;
        this.parent = other.parent;
    }
	State(Board boardState, int[] move, String color, State parent){
		this.boardState = boardState;
		this.move = move;
        this.nextMove = null;
        this.color = color;
        if(this.color.equals("W")){
            this.nextColor = "B";
        } else {
            this.nextColor = "W";
        }
		this.value = null;
		this.parent = parent;
        this.lastChecked = null;
	}
	public Board getBoardState() {
		return boardState;
	}
	public void setBoardState(Board boardState) {
		this.boardState = boardState;
	}
	public int[] getMove() {
		return move;
	}
	public void setMove(int[] move) {
		this.move = move;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public State getParent() {
		return parent;
	}
	public void setParent(State parent) {
		this.parent = parent;
	}
	public ArrayList<State> getNextPossibleState(String color){ return boardState.getPossibleStates(color); }
    public String getColor(){return color;}
    public void setColor(String color){this.color = color;}
    public String getNextColor(){return nextColor;}
    public void setNextColor(String nextColor){this.nextColor = nextColor;}
    public int[] getNextMove(){ return nextMove;}
    public void setNextMove(int[] nextMove){ this.nextMove = nextMove;}

    /**
     * Gets the next state in the possible state list.
     * @return The child state of the board.
     */
    public State getNextState(){

        if (lastChecked == null){
            lastChecked = new int[]{-1,-1};
        }

        while(lastChecked[0] < boardState.getXMax()){
            while (lastChecked[1] < boardState.getYMax()){
                int[] move = new int[]{lastChecked[0], lastChecked[1]};
                Board b = boardState.getBoard(move, nextColor);
                lastChecked[1]++;
                if (b != null){
                    return new State(b, move, nextColor, this);
                }
            }
            if(lastChecked[0] != boardState.getXMax() - 1){
                lastChecked[1] = 0;
            }
            lastChecked[0]++;
        }

        if (lastChecked[0] == boardState.getXMax() - 1 && lastChecked[1] == boardState.getXMax() - 1 ){
            lastChecked = null;
        }

        return null;
    }

    /**
     * Returns the number of next states.
     * @return The number of possible moves to be made.
     */
    public int getNextStateCount(){

        int counter = 0;

        for(int i = 0;i< boardState.getXMax(); i++) {
            for (int j = 0; j < boardState.getYMax(); j++) {
                Board b = boardState.getBoard(new int[]{i, j}, nextColor);
                if (b != null) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
