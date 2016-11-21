//gets the score difference
public class ScoreDifference implements Evaluation {

	@Override
	public int evaluate(Board board, Player player) {
		return board.count(player.color()) - board.count(player.opponent().color());
	}