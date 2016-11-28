
public class AIPlayer extends Player {

	private MinMax algorithm; //which search to use

	//default constructor
	AIPlayer(){
		super();
	}
	AIPlayer(String search, Board board, String color){
		super(board,color);

		if (search.equals("GREEDY")){
			this.algorithm = new MinMaxGreedy(board, color);
		} else {
            System.out.println("Unknown search heuristic. Defaulting to greedy.");
			this.algorithm = new MinMaxGreedy(board, color);
		}
	}

	//call MinMax method getMove and set that as the move and return it
	public int[] move() {
		System.out.println("AI executing move");
        skipping = false;

        int[] nextMove = algorithm.getMove();

        if (nextMove == null){
            skipping = true;
        }
		return nextMove;
	}

}
