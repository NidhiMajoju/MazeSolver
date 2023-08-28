import java.util.EmptyStackException;

public class MyStack<S> implements StackADT {
    private Square [] stack;
    private int size;

    public MyStack()
    {
        //what is default size?
        this (7);
        size = 0;
    }
    public MyStack (int initCap)
    {
        stack = new Square [initCap];
    }
    public boolean isEmpty()
    {
        return size ==0;
    }

    @Override
    public void clear() {
        while (size>=0)
        {
            pop();
        }

    }

    public Square peek ()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            return stack[size-1];
        }
    }

    @Override
    public int size() {
        return size;
    }

    public Square pop()
    {
        Square popped = null;
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            popped = stack[size-1];
            stack[size-1] = null;
            size--;
        }
        return popped;
    }
    public void push (Square item)
    {
        if (size == stack.length)
        {
            doubleCapacity();
        }

        stack[size] = item;
        size++;
    }
    private void doubleCapacity()
    {
        Square [] stack2 = new Square [stack.length*2];
        for (int i =0; i<stack.length; i++)
        {
            stack2[i] = stack[i];
        }
        stack = stack2;
    }
    public String toString ()
    {
        String str = stack[size-1] + "\t<----- TOP";

        for (int i=size-2;i>=0;i--)
        {
            str += "\n" + stack[i];
        }
        return str += "\n-------";
        //like from bottom to top, vertical, how it is on other labs?
    }
}