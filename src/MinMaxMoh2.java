
public class MinMaxMoh2 extends MinMax {
	
	private int weight = 100;
	
	MinMaxMoh2(){super();}
	MinMaxMoh2(Board board, int depth, String maxColor){
		
		super(board, depth, maxColor);
	}

	@Override
	public int e(State n) {

		//
		int maxCount = n.getBoardState().count(maxColor);
		int minCount = n.getBoardState().count(minColor);
		
		int maxMoves  = n.getBoardState().c
		
		return weight * ((maxCount - minCount)/(maxCount + minCount ));
	}
}




