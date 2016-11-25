/**
 * Created by Maksym on 11/15/2016.
 */
public abstract class Player extends Board {
	
	//Player can either be black or white
	public final boolean BlackPlayer; 
	public final boolean WhitePlayer =false;
	public final boolean player = false;
	private String color;
	
	
	//constructor
	private Player(Square color) {
		 this.color = color.getColor();
	}
	
	public boolean getOpponent() {

		if(color.getColor() == "B"){
			return player = WhitePlayer;
		}
		else{return BlackPlayer;}	
	}
	//return the color of the square
	public String color() {
		return color.getColor();
	}
}


//public final boolean Black(Square.), 
//public final boolean White(Square.WHITE);

//	return this.color == color.getColor() == 'B'  ? WHITE : BLACK;