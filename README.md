# Othello (Reversi)
Othello game engine with MinMax alph-beta pruning system. Several modes are implemented including PvP, PvAI, AIvsAI.

## Heuristics 

For this board game, we have implemented and tested a variety of  heuristics. A key strength shared among all the heuristics is that we were able to achieve searches with high depth without noticing a significant time delay. In addition, we were able to generate heuristics based on the difference in chips, the possible number of moves for a given board state, the prioritization of corner and adjacent squares. Moreover, the greedy search algorithm would play on a square where its’ chips would be greater than the opponent's chips, at depth one. 

### MOH1
Calculates the difference in chips between the Max player and the Min player. By setting a weight on a move we are able to prioritize a state where the Max player will have more chips then Min Player. For example we set a weight of 100 to given state where the Max player chip count is essentially greater than Min player chip's count.

**Pros**: can quickly generate a possible move and apply a weight, where little computation is required. Good for early game strategy.

**Cons**: Weak on high depths (4+), since the algorithm does not take advantage of traversed down states. As a result, the resulted move may not be the best possible move.   

### MOH2
Calculates the difference between the number of possible moves for the Max and Min players. It looks to minimize Min players’ possible moving options and looks to increase its own moving options based on the number of moves a stare results in.

**Pros**:can restrict opponent's options on the board and may force a bad move.

**Cons**: not plausible in late game( since the number of possible moves in a late game scenario becomes too restricted and may offer diminishing returns).

### MAKSYM1
Weighs two factors in order to determine the relative heuristic for the board position. Adds up total count of one chip color with count of possible moves resulting from this board state (with 0.5 weight each). Calculates this both for min and max and gets the difference. 

**Pros**: Weighs chips with moves, giving a good estimation with little computation needed

**Cons**: Weak on low depths (the potential move part only starts being a plus on depths 3+)

### MAKSYM2
Weighs four factors in order to determine the relative heuristic of this position. Adds up possible moves resulting from this board state with pieces in corner, opponent pieces in diagonals from said corners and opponent pieces in straight lines from corners. Sums it up with weights skewing towards corners and corner diagonals (both of which are very powerful, with corner resulting in an unflippable tile while diagonal almost always results in the opponent getting the corner a couple of turns later. The straits from the corners also weigh negatively, but less so. Calculates this both for min and max and gets the difference.

**Pros**: Uses a combination of factors, none of which are the piece count. This is since the count itself doesn't matter all that much until the end of the game, with the ultimate deciding factors being the player who controls the corners, which this algorithm is designed to do

**Cons**: Might lose out to better optimized similar algorithms for late game ( as late game, the actual count of pieces begins to matter). A varying weight system to take this into account late game could be a potential improvement. 
