package in.ushatech.dsa.queue;

import java.util.Arrays;

public class QueueUsingCircularArray {
    int[] arr;
    int beginning;
    int top;
    int capacity;

    public QueueUsingCircularArray(int capacity) 
    {
        this.capacity=capacity;
        arr = new int[capacity];
        Arrays.fill(arr, Integer.MIN_VALUE);
        top = -1;
        beginning = -1;
    }
    //ok
    public boolean isEmpty() {
        return top == -1;
    }

    // ok
    public int peek() {
        if (!isEmpty())
            return arr[beginning];

        return Integer.MIN_VALUE;
    }

    public void enQueue(int value) {
        if (isEmpty())
        {
            top=beginning=0;
            arr[top]=value;
            return;
        }

        if(isFull())
        {
            return ;
        }

        top = (top+1)%capacity;
        arr[top] = value;

    }

    public boolean isFull() {
        return (top+1)%capacity == beginning;
    }

    

    // removes first element
    // TODO
    public int deQueue() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        int result = arr[beginning];
        beginning=(beginning+1)%capacity;
        if (beginning > top) {
            top = beginning = -1;
            arr = new int[arr.length];
        }
        return result;
    }


}
