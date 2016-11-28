/**
 * Created by Maksym on 11/27/2016.
 */
public class MinMaxMaksym2 extends MinMax {

    private static final int[][] CORNERS = new int[][]{{0,0}, {0,7}, {7,0}, {7,7}};
    private static final int[][] DIAGONALS = new int[][]{{1,1}, {1,6}, {6,1}, {6, 6}};
    private static final int[][][] STRAIGHTS = new int[][][]{{{0,1}, {1,0}}, {{0,6}, {1, 7}},
            {{6, 0}, {7, 1}}, {{7, 6}, {6, 7}}
    };

    private static final float WEIGHT_1 = 0.25f;
    private static final float WEIGHT_2 = 0.50f;
    private static final float WEIGHT_3 = 0.15f;
    private static final float WEIGHT_4 = 0.50f;

	MinMaxMaksym2(){super();}
	MinMaxMaksym2(Board board, int depth, String maxColor){
		super(board, depth, maxColor);
	}

	@Override
	public int e(State n) {

        // This heuristic completely disregards current count (with the exception of checking for losses)
        // in favor of calculating the potential moves + the corner pieces + x squares + c squares

        // Calculates potential moves for the player
        int potMax, potMin;

        if(n.getNextColor().equals(maxColor)){

            // If the absolute count is 0, this is horrible for max
            if (n.getBoardState().count(maxColor) == 0 && n.getBoardState().count(minColor) != 0){
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
            if (n.getBoardState().count(minColor) == 0 && n.getBoardState().count(maxColor) != 0){
                return MAX_INT;
            }
            potMin = n.getNextStateCount();

            // Estimates potMax as if it was their turn
            State newState = new State(n);

            newState.setColor(minColor);
            newState.setNextColor(maxColor);

            potMax = newState.getNextStateCount();
        }

        // Checks the diagonals next to the corners
        int minDiagonals = 0, maxDiagonals = 0;
        // Checks the straights next to the corner
        int minStraights=0,maxStraights=0;
        // Checks actual corner count
        int minCorners=0, maxCorners=0;

        for (int i = 0; i<CORNERS.length; i++){
            Board.Square corner = n.getBoardState().getSquare(CORNERS[i][0], CORNERS[i][1]);

            if (corner==null){
                // Occurs if the corner is empty

                // Checks the diagonal adjacent to the corner
                Board.Square s = n.getBoardState().getSquare(DIAGONALS[i][0], DIAGONALS[i][1]);
                if (s!=null){
                    if (s.getColor().equals(maxColor)){
                        maxDiagonals++;
                    } else {
                        minDiagonals++;
                    }
                }
                int[][] tempStraights = STRAIGHTS[i];
                for (int[] tempStraight: tempStraights){
                    Board.Square s2 = n.getBoardState().getSquare(tempStraight[0], tempStraight[1]);
                    if (s2!=null){
                        if (s2.getColor().equals(maxColor)){
                            maxStraights++;
                        } else {
                            minStraights++;
                        }
                    }
                }
            } else {
                if(corner.getColor().equals(maxColor)){
                    maxCorners++;
                } else {
                    minCorners++;
                }
            }

        }

		// This heuristic will sum the factors. Note that min diagonals, straights is being added to the max count,
        // as having a piece in one of these places is a negative and thus helps the other player
		int maxCount = (int) (WEIGHT_1 * (float)potMax +
                WEIGHT_2 * (float)minDiagonals + WEIGHT_3 * (float)minStraights + WEIGHT_4 * (float)maxCorners);
        int minCount = (int) (WEIGHT_1 * (float)potMin +
                WEIGHT_2 * (float)maxDiagonals + WEIGHT_3 * (float)maxStraights + WEIGHT_4 * (float)minCorners);


		return maxCount - minCount;
	}
}
