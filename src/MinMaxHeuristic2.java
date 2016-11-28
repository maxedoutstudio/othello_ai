/**
 * Created by Maksym on 11/27/2016.
 */
public class MinMaxHeuristic2 extends MinMax {

	MinMaxHeuristic2(){super();}
	MinMaxHeuristic2(Board board, int depth, String maxColor){
		// Greedy has a depth of 1 (to make it work with MinMax class).
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
