import java.util.ArrayList;

public abstract class MinMax {

	//variables
	private Board board; 
	private int depth;
	MinMax(){} //default constructor
	MinMax(Board board, int depth){
		
		this.board = board;
		this.depth = depth;
	}
	
	abstract public int evaluate(Board board);

	public int[] getMove(){
		ArrayList<ArrayList<State>> tree;
		ArrayList<State> lastState = new ArrayList<State>();
		lastState.add(new State(board,null,null));
		//generate tree for all states depending on depth
		for(int i = -1; i<depth; i++){
			ArrayList<State> states = lastState.getPossibleStates();
			tree.add(states);
		}
		//start from last layer loop upwards
		for(int i = tree.size()-1; i>=0; i--){
			//loop inner
			for(int j=0; j<tree.get(i).size(); j++){
				//Accessing state
				tree.get(i).get(j).setValue(evaluate(tree.get(i).get(j).getBoardState()));
			}
		}
		return new int[]{x,y};
	}
	

}
