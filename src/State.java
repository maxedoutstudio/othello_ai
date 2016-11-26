import java.util.ArrayList;

public class State {

	Board boardState;
	int[] move;
	int value;
	State parent;
	State(Board boardState, int[] move, State parent){
		
		this.boardState = boardState;
		this.move = move;
		this.value = -1;
		this.parent = parent;
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
	public int getValue() {
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
	
	public ArrayList<State> getPossibleStates(){
		return board.getPossibleStates();
	}
	
}
