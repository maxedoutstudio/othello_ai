/**
 * Created by Maksym on 11/27/2016.
 */
public class MinMaxHeuristic1 extends MinMax {

	MinMaxHeuristic1(){super();}
	MinMaxHeuristic1(Board board, int depth, String maxColor){
		// Greedy has a depth of 1 (to make it work with minmax class).
		super(board, depth, maxColor);
	}

	@Override
	public int e(Board n) {

		// This heuristic will sum
		int maxCount = n.count(maxColor);
		int minCount = n.count(minColor);

		return maxCount - minCount;
	}
}
