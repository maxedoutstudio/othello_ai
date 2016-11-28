
public class MinMaxMoh1 extends MinMax {
	
	//add a weight to a possible state 
	private int weight = 100;
	
	//default constructor
	MinMaxMoh1(){super();}
	MinMaxMoh1(Board board, int depth, String maxColor){
		
		super(board, depth, maxColor);
	}

	@Override
	//evaluate heuristic
	public int e(State n) {

		//the difference in chips between the MAX player and the MIN player. 
		int maxCount = n.getBoardState().count(maxColor);
		int minCount = n.getBoardState().count(minColor);
		//based on added weight
		return weight * ((maxCount - minCount)/(maxCount + minCount ));
	}
}
