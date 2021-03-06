
public class AIPlayer extends Player {

    private static int DEFAULT_DEPTH = 1; //default depth to be used
	private MinMax algorithm; //which MinMax search to use

	//default constructor
	AIPlayer(){
		super();
	}
	//constructor using default depth
	AIPlayer(String search, Board board, String color){
		super(board,color);
        if (search.equals("GREEDY")){
            this.algorithm = new MinMaxGreedy(board, color);
        } else if (search.equals("MAKSYM1")){
            this.algorithm = new MinMaxMaksym1(board, DEFAULT_DEPTH, color);
        } else if (search.equals("MAKSYM2")){
            this.algorithm = new MinMaxMaksym2(board, DEFAULT_DEPTH, color);
        } else if (search.equals("MOH1")){
        	 this.algorithm = new MinMaxMoh1(board, DEFAULT_DEPTH, color);
        } else if (search.equals("MOH2")){
        	 this.algorithm = new MinMaxMoh2(board, DEFAULT_DEPTH, color);
        }
        else {
            System.out.println("Unknown search heuristic. Defaulting to greedy.");
            this.algorithm = new MinMaxGreedy(board, color);
        }
	}
	//constructor using a given depth
	AIPlayer(String search, Board board, String color, int depth){
        super(board,color);
        if (search.equals("GREEDY")){
            this.algorithm = new MinMaxGreedy(board, color);
        } else if (search.equals("MAKSYM1")){
            this.algorithm = new MinMaxMaksym1(board, depth, color);
        } else if (search.equals("MAKSYM2")){
            this.algorithm = new MinMaxMaksym2(board, depth, color);
        } else if (search.equals("MOH1")){
        	 this.algorithm = new MinMaxMoh1(board, depth, color);
        } else if (search.equals("MOH2")){
        	 this.algorithm = new MinMaxMoh2(board, depth, color);
        }
        else {
        	//when no search is specified
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
        lastMove = nextMove;
		return nextMove;
	}
}
