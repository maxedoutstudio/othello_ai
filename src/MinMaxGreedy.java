
public class MinMaxGreedy extends MinMax{

	MinMaxGreedy(){super();}
	MinMaxGreedy(Board board, String maxColor){
		// Greedy has a depth of 1 (to make it work with minmax class).
		super(board, 1, maxColor);
	}

	@Override
	public int e(State n) {

		int maxCount = n.getBoardState().count(maxColor);
		int minCount = n.getBoardState().count(minColor);

		return maxCount - minCount;
	}

}
