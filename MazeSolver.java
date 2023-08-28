import java.util.Stack;

public abstract class MazeSolver {
    private  Maze maze;
    private boolean solved;
    private boolean solvable;
    MazeSolver (Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
        solved = false;
        solvable = true;

    }
    public abstract void makeEmpty();
    public abstract boolean isEmpty();
    public abstract void add (Square s);
    public abstract Square next ();
    public abstract Square show();
    public boolean isSolved()
    {
        return !solvable||solved;
    }
    public  void step()
    {
        if (isEmpty())
        {
            solved = true;
            solvable = false;
        }
        else if  (show().getType() == Square.EXIT)
        {
            solved = true;
            show().setStatus(Square.EXPLORED);
        }
        else
        {
            Square sqr = next();
            for (Square S : maze.getNeighbors(sqr))
            {
                if (S.getType() == Square.EXIT)
                {
                    solved = true;
                    break;
                }
                if (S.getStatus()== Square.UNKNOWN && S.getType()==Square.EMPTY)
                {
                    add(S);
                    S.setStatus(Square.WORKING);
                }
            }
            sqr.setStatus (Square.EXPLORED);
        }
    }
    public String getPath ()
    {
        if (isSolved())
        {
            return "Maze is solved";
        }
        if (!isSolved() && !isEmpty())
        {
            return "Maze is not solved";
        }
        return "Maze is unsolvable";
    }
    public void solve()
    {
        while (!isSolved())
        {
            step();
        }
    }

}