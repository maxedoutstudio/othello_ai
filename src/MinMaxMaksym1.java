/**
 * Created by Maksym on 11/27/2016.
 */
public class MinMaxMaksym1 extends MinMax {

    private static final float WEIGHT_1 = 0.50f;
    private static final float WEIGHT_2 = 0.50f;

	MinMaxMaksym1(){super();}
	MinMaxMaksym1(Board board, int depth, String maxColor){
		super(board, depth, maxColor);
	}

	@Override
	public int e(State n) {

        // This heuristic weighs the overall position with the potential moves on the board

        // Calculates potential moves for the player
        int potMax, potMin;
        if(n.getNextColor().equals(maxColor)){
            // If the absolute count is 0, this is horrible for max
            if (n.getBoardState().count(maxColor) == 0){
                return -MIN_INT;
            }

            potMax = n.getNextStateCount();

            // Estimates potMin as if it was their turn
            State newState = new State(n);

            newState.setNextColor(minColor);
            newState.setColor(maxColor);

            potMin = newState.getNextStateCount();

        } else {
            // If the absolute count is 0, this horrible for min
            if (n.getBoardState().count(minColor) == 0){
                return MAX_INT;
            }
            potMin = n.getNextStateCount();

            // Estimates potMax as if it was their turn
            State newState = new State(n);

            newState.setColor(minColor);
            newState.setNextColor(maxColor);

            potMax = newState.getNextStateCount();
        }

		// This heuristic will sum
		int maxCount = (int) (WEIGHT_1 * n.getBoardState().count(maxColor) + WEIGHT_2 * (float)potMax);
        int minCount = (int) (WEIGHT_1 * n.getBoardState().count(minColor) + WEIGHT_2 * (float)potMin);

		return maxCount - minCount;
	}
}
