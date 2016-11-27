import java.util.ArrayList;

public class State {

	private Board boardState;
	private int[] move;

    private String color;
    private String nextColor;

	private Integer value;

	private State parent;

    // Helper variable for getNextState (used for DFS)
	private int[] lastChecked;

	State(Board boardState, int[] move, String color, State parent){
		this.boardState = boardState;
		this.move = move;
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
    public String getNextColor(){return nextColor;}

    /**
     * Gets the next state in the possible state list.
     * @return The child state of the board.
     */
    public State getNextState(){

        if (lastChecked == null){
            lastChecked = new int[]{-1,-1};
        }

        for (int x = ++lastChecked[0]; x<boardState.getXMax(); x++,lastChecked[0]++){
            for (int y = ++lastChecked[1]; y<boardState.getYMax(); y++,lastChecked[1]++){
                int[] move = new int[]{x,y};
                Board b = boardState.getBoard(move, nextColor);
                if (b != null){
                    return new State(b, move, nextColor, this);
                }
            }
        }

        if (lastChecked[0] == boardState.getXMax() - 1 && lastChecked[1] == boardState.getXMax() - 1 ){
            lastChecked = null;
        }

        return null;
    }

}
