
public class AIPlayer extends Player {

    private static int DEFAULT_DEPTH = 1;

	private MinMax algorithm; //which search to use

	//default constructor
	AIPlayer(){
		super();
	}
	AIPlayer(String search, Board board, String color){
		super(board,color);
        if (search.equals("GREEDY")){
            this.algorithm = new MinMaxGreedy(board, color);
        } else if (search.equals("MAKSYM1")){
            this.algorithm = new MinMaxMaksym1(board, DEFAULT_DEPTH, color);
        } else if (search.equals("MAKSYM2")){
        } else if (search.equals("MOH1")){
        } else if (search.equals("MOH2")){
        }
        else {
            System.out.println("Unknown search heuristic. Defaulting to greedy.");
            this.algorithm = new MinMaxGreedy(board, color);
        }
	}

	AIPlayer(String search, Board board, String color, int depth){
        super(board,color);
        if (search.equals("GREEDY")){
            this.algorithm = new MinMaxGreedy(board, color);
        } else if (search.equals("MAKSYM1")){
            this.algorithm = new MinMaxMaksym1(board, depth, color);
        } else if (search.equals("MAKSYM2")){
        } else if (search.equals("MOH1")){
        } else if (search.equals("MOH2")){
        }
        else {
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
