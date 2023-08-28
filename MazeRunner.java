import java.util.Stack;
import java.util.Stack.*;
public class MazeRunner {
    public static void main (String args [])
    {
        Maze trial = new Maze();
        trial.loadMaze("src/maze-2");
        System.out.print(trial);
    }
}