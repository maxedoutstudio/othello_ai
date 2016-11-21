/**
 * The interface provides searching using of A-B pruning
 * basic init call is: search(board, player, Integer.MIN_VALUE, Integer.MAX_VALUE, depth, ef)
 */
interface GameSearcher {

	GameSearcher search(final Board board, final Player player, int alpha,
			    int beta, final int depth, final Evaluation function);
}

//interface SimpleSearcher {
//
//	SimpleSearcher  search(final Board board, final Player player,
//				  final int depth, final Evaluation function);
//}
