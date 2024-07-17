package in.ushatech.dsa;
import java.util.*;

public class Queue 
{
    int[] arr;
    int beginning;
    int top;
    public Queue(int capacity)
    {
        arr=new int[capacity];
        Arrays.fill(arr, Integer.MIN_VALUE);
        top=-1;
        beginning=-1;
    }

    public boolean isFull()
    {
        return top==arr.length-1;
    }

    public boolean isEmpty()
    {
        return top==-1 ;
    }

    public void enQueue(int value)
    {
        if(isFull()) return;
        
        if(isEmpty())
        {
            top=beginning=0;
            arr[top]=value;
            return;
        }

        arr[++top]=value;
    }

    // removes first element 
    public int deQueue()
    {
        if(isEmpty()) return Integer.MIN_VALUE;

        int result = arr[beginning];
        ++beginning;       
        if(beginning>top) 
        {
            top=beginning=-1;
            arr=new int[arr.length];
        }
        return result;
    }

    public int peek()
    {
        if(!isEmpty()) return arr[beginning];

        return Integer.MIN_VALUE;
    }
}
