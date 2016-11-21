/**
 * A game search results consists of a mapping of a move to it's result
 * obtained by the evaluation method that was chosen
 */
public class GameSearchResult {

	private Point point;
	private int score;

	public int getScore() {
		return score;
	}

	public Point getPoint() {
		return point;
	}

	public SearchResult negated() {
		return new SearchResult(point, -score);
	}

	public SearchResult(Point point, int score) {
		this.point = point;
		this.score = score;
	}
}
