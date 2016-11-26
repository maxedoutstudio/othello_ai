import java.util.Scanner;

/**
 * Created by Maksym on 11/15/2016.
 */
public abstract class Player {
	
	protected String color;
    protected boolean skipping;

	Player(){
		this.color = "W";
        skipping = false;
	}
	
	//constructor
	Player(String color) {
        this.color = color;
        skipping = false;
	}

	//get opponent
	public String getOpponent() {

		if(color.equals("B")){
			return "W" ;
		}
		else{return "B";}	
	}
	//return the color of the square
	public String color() {
		return color;
	}

	public boolean getSkipping(){
        return skipping;
    }

    public void setSkipping(boolean skipping){this.skipping = skipping;}

	//move
	abstract public int[] move();
}

