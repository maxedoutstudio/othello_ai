import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
	
	class Square{
	
		private boolean color;
		
		public final static boolean WHITE = true;
		public final static boolean BLACK = true;
		
		public Square(Square other){
			this.color = other.color;
		}
		
		public Square(String color){
			if (color == "W" || color == "w"){
				this.color = true;
			} else if (color == "B" || color == "b"){
				this.color = false;
			} else {
				throw new IllegalArgumentException();
			}
		}
		
		public Square(boolean color){
            this.color = color == true;
		}
		
		public boolean equals(Square other){
            return this.color == other.color;
        }
		
		public String getColor(){
			if (color == true){
				return "W";
			} else {
				return "B";
			}
		}
		//if this square equals to black then return white else return black. 
		public boolean opposite() {
			return this.color == BLACK ? WHITE : BLACK;
		}
		
	}
	
	private final String[][] DEFAULT_BOARD = new String[][]{
		{null,null,null,null,null,null,null,null},
		{null,null,null,null,null,null,null,null},
		{null,null,null,null,null,null,null,null},
		{null,null,null,"W", "B",null,null,null},
		{null,null,null,"B", "W",null,null,null},
		{null,null,null,null,null,null,null,null},
		{null,null,null,null,null,null,null,null},
		{null,null,null,null,null,null,null,null},
	};
	
	private enum Direction {
		NORTH (0, -1),
		SOUTH (0, 1),
		EAST (1, 0),
		WEST(-1, 0),
		NORTH_EAST(1, -1),
		NORTH_WEST(-1, -1),
		SOUTH_EAST(1, 1),
		SOUTH_WEST(-1, 1);
		
		private int x_o, y_o;
		
		Direction(int x_o, int y_o){
			this.x_o = x_o;
			this.y_o = y_o;
		}
		
		private int getXOffset(){
			return x_o;
		}
		
		private int getYOffset(){
			return y_o;
		}
	}
	
	private static final int BOARD_SIZE = 8;

	private Square board[][] = new Square[BOARD_SIZE][BOARD_SIZE];

	private int count;

    /**
     * The main default constructor to create a board object.
     */
	public Board(){

		// Initializes the default board
		for (int i = 0; i<board.length; i++){
			
			for (int j = 0; j<board[i].length; j++){
				
				if (DEFAULT_BOARD[i][j] != null){
					board[i][j] = new Square(DEFAULT_BOARD[i][j]);
				} else {
					board[i][j] = null;
				}
				
			}
		}

		// Initializes the square counter;
		count = 4;

	}

    /**
     * Copy constructor that makes a deep copy of another board.
     * @param other The other board object.
     */
	public Board(Board other){

        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[i].length; j++){
                if (other.board[i][j] != null){
                    board[i][j] = new Square(other.board[i][j]);
                } else {
                    board[i][j] = null;
                }
            }
        }
    }

    public int getXMax(){
        return board.length;
    }

    public int getYMax(){
        return board[0].length;
    }

    public Square getSquare(int x, int y){
        return new Square(board[x][y]);
    }

    /**
     * Setter function to set the value of a square on the board.
     * @param x
     * @param y
     * @param square
     */
	private void setSquare(int x, int y, Square square){
		this.board[x][y] = square;
	}

    /**
     * Attempts to place a piece at a specific location. Verifies the location's validity.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param color The color of the piece.
     * @throws Exception If the placement of the piece is not possible.
     */
	public void place(int x, int y, String color) throws Exception{
		
		// Part 1: Check if placement cell is valid
		if (x >= this.board.length || y >= this.board[0].length || x < 0 || y < 0){
			throw new Exception("Invalid x,y placement coordinates.");
		}
		
		if (board[x][y] != null){
			throw new Exception("Cell at x,y coordinates is occupied!");
		}
		
		// Part 2.1: Creates square object for the color
		Square sq = new Square(color);
		
		// Part 2.2: Adds the cells that are off different color to an array
		boolean found = false;

		for (Direction direction: Direction.values()){

            // Checks if the square is off board
            if (x+direction.getXOffset() >= this.board.length || y+direction.getYOffset() >= this.board[0].length
                    || x+direction.getXOffset() < 0 || y+direction.getYOffset() < 0){
                continue;
            }

			// Checks each direction for a cell of different color
			if (board[x + direction.getXOffset()][y + direction.getYOffset()] != null &&
                    !board[x + direction.getXOffset()][y + direction.getYOffset()].equals(sq)){
                ArrayList<int[]> coords = new ArrayList<>();
                try{
                    coords.addAll(validCellHelper(
                            x + direction.getXOffset(),
                            y + direction.getYOffset(),
                            direction,
                            board[x + direction.getXOffset()][ y + direction.getYOffset()]
                    ));
                } catch (Exception e){
                    // Means that no valid square was found this round.
                }

                if(!coords.isEmpty()){
                    found = true;
                    // Sets the square to the value
                    setSquare(x, y, sq);
                }

                // Sets the middle squares to the value
                for(int[] coord: coords){
                    setSquare(coord[0], coord[1], sq);
                }
			}
		}

		if(!found){
			throw new Exception("Cell at x,y coordinates is invalid (Does not meet rules conditions).");
		}

	}

    /**
     * Tests whether a place would be valid. Adds up the possible boards resulting from this placement.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param color The color of the piece.
     * @return The new Board object resulting from this placement, or null if placement is not possible.
     */
    private Board placeNew(int x, int y, String color){

        Board b = new Board(this);

        try{
            b.place(x, y, color);
        } catch (Exception e){
            return null;
        }

        return b;

    }

    /**
     * Recursive helper method that iterates over a line pattern in a given direction. Returns ArrayList of line.
     * @param x The x value of the coordinates.
     * @param y The y value of the coordinates.
     * @param direction The direction of the line.
     * @param square The starting square of the line.
     * @return
     */
	private ArrayList<int[]> validCellHelper(int x, int y, Direction direction, Square square) throws Exception {

        ArrayList<int[]> coords = new ArrayList<>();

		// Checks if the square is off the board
		if (x > this.board.length || y > this.board[0].length || x < 0 || y < 0){
			throw new Exception("ValidCellHelper Exception: Reached end of board");
		}
		
		// Checks if the square is none
		if (this.board[x][y] == null){
            throw new Exception("ValidCellHelper Exception: Reached empty square");
		}
		
		if (this.board[x][y].equals(square)){
			// Checks if the square is of the same color, and if so, progresses the chain
            coords.addAll(validCellHelper(x + direction.getXOffset(), y + direction.getYOffset(), direction, square));
		}
        int[] tempA = {x, y};
        coords.add(tempA);

		return coords;
	}

	/**
	 * Check if board is full parse through each square on the board and check if a square is empty
	 * @return Whether the board is full with pieces or not.
	 */
	public boolean isFull() {
		return (BOARD_SIZE*BOARD_SIZE - count) == 0;
	}

    /**
     * Returns the count of the specified color pieces on the board.
     * @param color The color to query for.
     * @return The count of the pieces of the specified color.
     */
	public int count(String color){
        int count = 0;
        for(int i = 0;i < board.length; i++){
            for(int j = 0;j < board[i].length; j++){
                if (board[i][j] != null){
                    if (board[i][j].getColor().equals(color)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Checks the board for its end state.
     * @return Whether the board is in an end state or not.
     */
	protected boolean isEndState() {
		return (isFull() || count("W") == 0 || count("B") == 0);
	}

    /**
     * Gets the string representation of the board.
     * @return String representation of the board.
     */
    public String toString(){
        String output = "  0 1 2 3 4 5 6 7\n";
        for (int j = 0; j<board[0].length; j++){
            output += j + " ";
            for (int i = 0; i<board.length; i++){
                if (board[i][j] == null){
                    output += "O ";
                } else  {
                    output += board[i][j].getColor() + " ";
                }
            }
            output += "\n";
        }
        return output;
    }
    
    public String toStringOutPutFile(){
        String output = "(";
        for (int j = 0; j<board[0].length; j++){
            output += "(";
            for (int i = 0; i<board.length; i++){
                if (board[i][j] == null){
                    output += "0";
                } else  {
                    output += board[i][j].getColor();
                }
            }
            output += ")";
        }
        output += ")";
        return output;
    }

    /**
     * Returns all possible state objects resulting from this position.
     */
    public ArrayList<State> getPossibleStates(String color){

        // Makes a state for the current board
        State currentState = new State(this, null, null, null);

        ArrayList<State> states = new ArrayList<>();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length;j++){
                if (board[i][j] == null){

                    Board b = placeNew(i,j,color);

                    if ( b != null){
                        int[] move = new int[]{i, j};
                        State s = new State(b, move,color, currentState);
                        states.add(s);
                    }

                }
            }
        }

        if (states.isEmpty()){
            return null;
        } else {
            return states;
        }
    }

    /**
     * Creates a state resulting from a move and returns it.
     * @param move: The x,y coordinates of the move.
     * @param color: The color of the move.
     * @return State resulting from move or null if move not possible.
     */
    public Board getBoard(int[] move, String color){
        return placeNew(move[0], move[1], color);
    }
}