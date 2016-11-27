
public class AIPlayer extends Player {

	private MinMax search; //which search to use 
	//default constructor
	AIPlayer(){
		super();
	}
	AIPlayer(MinMax search, String color){
		super(color);
		this.search = search;
	}
		
	//call MinMax method getMove and set that as the move and return it
	public int[] move() {
		System.out.println("AI executing move");
		int x=-1,y=-1;
		
		try{
			// x and y -> search.getMove
		}
		catch(Exception e){
						
		}
		
		return new int[]{x,y};	
	}
	
}
