package in.ushatech.dsa.queue;

import in.ushatech.dsa.linkedlist.LinkedList;

public class QueueUsingLinkedList {
    LinkedList queue; 
    public QueueUsingLinkedList() {
        queue=new LinkedList();
    }

    public boolean isEmpty() {
        return queue.size==0;
    }

    public boolean isFull() 
    {
        return false;
    }

    public void enQueue(int value) {
        queue.insertNode(value);
    }

    public Integer peek() 
    {
        if(isEmpty()) return Integer.MIN_VALUE;
        
        return queue.head.value;
    }

    public Integer deQueue() 
    {
        return queue.deQueue();
    }
    
}
