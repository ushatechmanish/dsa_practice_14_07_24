package in.ushatech.dsa.queue;

import java.util.Stack;

public class QueueUsingStack
{
    Stack<Integer> s1; // new elements goes here
    Stack<Integer> queue;
    public QueueUsingStack()
    {
        s1 = new Stack<>();
        queue = new Stack<>();
    }

    public boolean isEmpty()
    {
        return queue.isEmpty() && s1.isEmpty();
    }

    public void enQueue(int value)
    {
        s1.push(value);
    }

    // removes first element 
    public int deQueue()
    {
        if(!queue.isEmpty())
        {
            return queue.pop();
        }
        moveStackToQueue();
        
        return queue.pop();
    }

    public int peek()
    {
        if(isEmpty()) return Integer.MIN_VALUE;

        if(!queue.isEmpty()) return queue.peek();

        moveStackToQueue();
        return queue.peek();

    }
    private void moveStackToQueue()
    {
        while(!s1.empty())
        {
            queue.push(s1.pop());
        }
    }
}
