
public class AIPlayer extends Player {

	private String search; //which search to use 
	//default constructor
	AIPlayer(){
		super();
	}
	AIPlayer(String search,String color){
		super(color);
		this.search = search;
	}
		
	//call MinMax method getMove and set that as the move and return it
	public int[] move() {
		System.out.println("AI executing move");
		int x=-1,y=-1;
		String x_input,y_input;
		skipping = false;
		try{
			// x and y -> search.getMove
		}
		catch(Exception e){
			
			if (x_input.equals("") && y_input.equals("")){
                skipping = true;
            }						
		}		
		return new int[]{x,y};	
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
}
