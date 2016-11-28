import java.util.ArrayList;

public class MinMaxMoh2 extends MinMax {
	//added a weight to a possible move
	private int weight = 100;
	//default constructor
	MinMaxMoh2(){super();}
	MinMaxMoh2(Board board, int depth, String maxColor){
		
		super(board, depth, maxColor);
	}

	@Override
	//evaluate heuristic
	public int e(State n) {
		//calculates the difference between the number of possible moves for the MAX and MIN players
		// looking to restrict openent's possible moving options by increasing its own
		//total number of squares in the board
		int total_squares = 64; 
		//get total number of chips for each player
		int maxCount = n.getBoardState().count(maxColor);
		int minCount = n.getBoardState().count(minColor);
		
		//calculater number of possible moves for each player
		int numOfMaxSquareMoves = ((total_squares - maxCount)+ minCount) + n.getNextStateCount();
		int numOfMixSquareMoves = ((total_squares - minCount)+ maxCount) + (n.getNextStateCount() - numOfMaxSquareMoves);
				
		//if there exists a state
		if ( numOfMaxSquareMoves + numOfMixSquareMoves != 0){
			return weight * (numOfMaxSquareMoves - numOfMixSquareMoves) / (numOfMaxSquareMoves + numOfMixSquareMoves);
		}
		else{
			return 0;
		}
	}
}




