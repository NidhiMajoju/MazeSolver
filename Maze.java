import java.util.*;
import java.io.*;
public class Maze
{
    private Square [][] maze;
    private Square start, exit;

    public Maze ()
    {
    }
    public boolean loadMaze(String fileName)
    {
        try
        {
            Scanner input = new Scanner (new File (fileName));
            maze = new Square[input.nextInt()][input.nextInt()];
            input.nextLine();
            int nextInt = 0;
            for (int r = 0; r<maze.length; r++)
            {
                for (int c = 0; c<maze[r].length; c++)
                {
                    maze [r][c] = new Square (r,c,input.nextInt());
                    if (maze[r][c].getType() == 2)
                    {
                        start = (maze[r][c]);
                    }
                    else if ((maze[r][c].getType() ==3))
                    {
                        exit = (maze[r][c]);
                    }
                }
            }

        }
        catch (IOException e)
        {
            System.out.println("Can't find the file!");
            return false;
        }
        return true;
    }
    public List<Square> getNeighbors (Square s)
    {
        List<Square> neighbors = new ArrayList <>();
        int row = s.getRow();
        int col = s.getCol();
        if (row-1>=0)
            neighbors.add(maze[row-1][col]);
        if (col+1<maze[row].length)
            neighbors.add(maze[row][col+1]);
        if (row+1<maze.length)
            neighbors.add(maze[row+1][col]);
        if (col-1>=0)
            neighbors.add(maze[row][col-1]);
        return neighbors;

    }
    public Square getStart()
    {
        return start;
    }
    public Square getExit ()
    {
        return exit;
    }
    public void reset ()
    {
        for (int r = 0; r<maze.length; r++){
            for (int c = 0; c<maze[r].length; c++)
            {
                maze[r][c].squareReset();
            }
        }
    }
    public String toString ()
    {
        String result = "";
        for (int r = 0; r<maze.length; r++)
        {
            for (int c= 0; c<maze[r].length; c++)
            {
                result += maze[r][c].toString()+" ";
            }
            result+= "\n";
        }
        return result;
    }

}