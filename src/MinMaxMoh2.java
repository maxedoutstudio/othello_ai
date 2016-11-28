
public class MinMaxMoh2 extends MinMax {
	
	private int weight = 10;
	
	MinMaxMoh2(){super();}
	MinMaxMoh2(Board board, int depth, String maxColor){
		// Greedy has a depth of 1 (to make it work with MinMax class).
		super(board, depth, maxColor);
	}

	@Override
	public int e(Board n) {

		// This heuristic will sum
		int maxCount = n.count(maxColor);
		int minCount = n.count(minColor);

		return weight * ((maxCount - minCount)/(maxCount + minCount ));
	}
}
