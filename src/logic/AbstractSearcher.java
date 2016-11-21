/**
 * Abstract searcher class, providing a random choice "search".
 * Implements basic helper methods like min and max and isEndState
 */
public abstract class AbstractSearcher implements Searcher, SimpleSearcher {

	@Override
	public abstract SearchResult search(final Board board, final Player player, int alpha,
					    int beta, final int depth, final Evaluation function);

	@Override
	public abstract SearchResult simpleSearch(final Board board, final Player player,
						  final int depth, final Evaluation function);

	protected int max(int a, int b) {
		return Math.max(a, b);
	}

	protected int min(int a, int b) {
		return Math.min(a, b);
	}

	protected Point randomChoice(Board board, Player player) {
		List<Point> possibleMoves = new ArrayList<Point>(board.getPossibleMoves(player));
		int record = (int) Math.random() * (possibleMoves.size() - 1);
		return possibleMoves.get(record);
	}

	
}