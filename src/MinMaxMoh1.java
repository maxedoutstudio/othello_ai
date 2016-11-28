
public class MinMaxMoh1 extends MinMax {
	
	private int weight = 100;
	
	MinMaxMoh1(){super();}
	MinMaxMoh1(Board board, int depth, String maxColor){
		
		super(board, depth, maxColor);
	}

	@Override
	public int e(State n) {

		//the difference in chips between the max player and the min player. 
		int maxCount = n.getBoardState().count(maxColor);
		int minCount = n.getBoardState().count(minColor);
		return weight * ((maxCount - minCount)/(maxCount + minCount ));
	}
}
