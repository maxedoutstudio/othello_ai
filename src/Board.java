public class Board {
	
	private class Square{
	
		private boolean color;
		
		public final boolean WHITE = true;
		public final boolean BLACK = true;
		
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
			if (color == true){
				this.color = true;
			} else {
				this.color = false;
			}
		}
		
		public boolean equals(Square other){
			if (this.color == other.color)
				return true;
			return false;
		}
		
		public String getColor(){
			if (color == true){
				return "W";
			} else {
				return "B";
			}
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
		
		private Direction(int x_o, int y_o){
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
	
	public Board(){
		
		for (int i = 0; i<board.length; i++){
			
			for (int j = 0; j<board[i].length; j++){
				
				if (DEFAULT_BOARD[i][j] != null){
					board[i][j] = new Square(DEFAULT_BOARD[i][j]);
				} else {
					board[i][j] = null;
				}
				
			}
		}
	}
	
	private void setSquare(int x, int y, Square square){
		this.board[x][y] = square;
	}
	
	public void place(int x, int y, boolean color) throws Exception{
		
		// Part 1: Check if placement cell is valid
		if (x > this.board.length || y > this.board[0].length || x < 0 || y < 0){
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
			// Checks each direction for a cell of different color
			if (!board[x + direction.getXOffset()][y + direction.getYOffset()].equals(sq)){
				if(validCellHelper( 
						x + direction.getXOffset(),
						y + direction.getYOffset(),
						direction,
						board[x + direction.getXOffset()][ y + direction.getYOffset()])){
					found = true;
					setSquare(x, y, sq);
					break;
				}
			}
		}
		
		if(!found){
			throw new Exception("Cell at x,y coordinates is invalid (Does not meet rules conditions).");
		}
		
	}
	
	private boolean validCellHelper(int x, int y, Direction direction, Square square){
		
		// Checks if the square is off the board
		if (x > this.board.length || y > this.board[0].length || x < 0 || y < 0){
			return false;
		}
		
		// Checks if the square is none
		if (this.board[x][y] == null){
			return false;
		}
		
		if (this.board[x][y].equals(square)){
			// Checks if the square is of the same color, and if so, progresses the chain
			validCellHelper(x + direction.getXOffset(), y + direction.getYOffset(), direction, square);
		} 
		
		return true;
	}
}