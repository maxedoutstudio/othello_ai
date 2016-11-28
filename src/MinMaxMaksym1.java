/**
 * Created by Maksym on 11/27/2016.
 */
public class MinMaxMaksym1 extends MinMax {

	MinMaxMaksym1(){super();}
	MinMaxMaksym1(Board board, int depth, String maxColor){
		super(board, depth, maxColor);
	}

	@Override
	public int e(Board n) {

        // This heuristic goes a number of moves ahead.

		// This heuristic will sum
		int maxCount = n.count(maxColor);
		int minCount = n.count(minColor);

		return maxCount - minCount;
	}
}
