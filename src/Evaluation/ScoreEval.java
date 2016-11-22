//maximizes score for player
public class ScoreEval implements Evaluation {

	@Override
	public int evaluate(final Board board, final Player player) {
		return board.count(player.color());
	}
}
