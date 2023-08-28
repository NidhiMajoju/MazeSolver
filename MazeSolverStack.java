public class MazeSolverStack extends MazeSolver{

    private MyStack <Square> workList;
    @Override
    public void step ()
    {
        System.out.println(workList.size());
        super.step();


    }
    public MazeSolverStack (Maze maze)
    {
        super (maze);
    }
    @Override
    public void makeEmpty() {
        workList = new MyStack<>();
    }

    @Override
    public boolean isEmpty() {
        return workList.isEmpty();
    }

    @Override
    public void add(Square s) {
        workList.push(s);
    }

    @Override
    public Square next() {
        return workList.pop();
    }

    public Square show()
    {
        return workList.peek();
    }
}
