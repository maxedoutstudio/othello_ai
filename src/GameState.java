import java.awt.Point;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class GameState
{
    private final int MAX=Integer.MAX_VALUE;
    private final int MIN=Integer.MIN_VALUE;
    private int maxDepth;
    Runtime r ;

    public GameState(int maxDepth)
    {
        this.maxDepth=maxDepth;
          r = Runtime.getRuntime();
          r.gc();
    }

    public GameMoves alpha_beta(GameOthello o)
    {
        
    	GameMoves m = max_Value(new GameOthello(o),MIN,MAX,0);
        r.gc();
        return m;
        
    }
    private GameMoves max_Value(GameOthello o,int a,int b,int depth)
    {
        if((o.isTerminal())||(depth==maxDepth))
        {
        	GameMoves lastMove=new GameMoves(o.getLastMove().getX(),o.getLastMove().getY(),o.evaluate());
            r.gc();
            return lastMove;
        }
        ArrayList<GameOthello> children =o.getChildren('W');
        GameMoves maxMove=new GameMoves(MIN);
        for(GameOthello child : children)
        {
        	GameMoves move=min_Value(child,a,b,depth+1);
            if(move.getValue()>=maxMove.getValue())
            {
                if(move.getValue()>=b){return move;} 
                maxMove.setX(child.getLastMove().getX());
                maxMove.setY(child.getLastMove().getY());
                maxMove.setValue(move.getValue());
                child=null;
                r.gc();
            }
            a=Math.max(a,move.getValue());
        }
        return maxMove;
    
    }
    private GameMoves min_Value(GameOthello o,int a,int b,int depth)
    {
        if((o.isTerminal())||(depth==maxDepth))
        {
        	GameMoves lastMove=new GameMoves(o.getLastMove().getX(),o.getLastMove().getY(),o.evaluate());
            r.gc();
            return lastMove;
        }
        ArrayList<GameOthello> children =o.getChildren('B');
        GameMoves minMove=new GameMoves(MAX);
        for(GameOthello child : children)
        {
        	GameMoves move=max_Value(child,a,b,depth+1);
            if(move.getValue()<=minMove.getValue())
            {
                if(move.getValue()<=a) {return move;} 
                minMove.setX(child.getLastMove().getX());
                minMove.setY(child.getLastMove().getY());
                minMove.setValue(move.getValue());
                child=null;
                r.gc();
            }
            b=Math.min(b,move.getValue());
        }
        return minMove;

    }
}
