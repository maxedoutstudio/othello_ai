import java.util.ArrayList;

public class MinMaxMoh2 extends MinMax {
	
	private int weight = 100;
	
	MinMaxMoh2(){super();}
	MinMaxMoh2(Board board, int depth, String maxColor){
		
		super(board, depth, maxColor);
	}

	@Override
	public int e(State n) {
		//calculates the difference between the number of possible moves for the MAX and MIN players
		// looking to restrict openent's possible moving options by increasing its own
		int total_squares = 64;
		int maxCount = n.getBoardState().count(maxColor);
		int minCount = n.getBoardState().count(minColor);
		
		int numOfMaxSquareMoves = ((total_squares - maxCount)+ minCount) + n.getNextStateCount();
		int numOfMixSquareMoves = ((total_squares - minCount)+ maxCount) + (n.getNextStateCount() - numOfMaxSquareMoves);
				
		
		if ( numOfMaxSquareMoves + numOfMixSquareMoves != 0){
			return weight * (numOfMaxSquareMoves - numOfMixSquareMoves) / (numOfMaxSquareMoves + numOfMixSquareMoves);
		}
		else{
			return 0;
		}
	}
}




