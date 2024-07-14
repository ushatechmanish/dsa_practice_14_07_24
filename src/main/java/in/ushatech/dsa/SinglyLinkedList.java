package in.ushatech.dsa;

public class SinglyLinkedList {
    int size;
    Node head;
    Node tail;
    
    public Node push(int value)
    {
        Node newNode = new Node();
        newNode.value=value;
        if(isEmpty())
        {
            head=tail=newNode;
        }
        else
        {
            tail.next=newNode;
            tail=tail.next;
        }
        increaseSize();
        return head;
        
    }
    
    public boolean isEmpty()
    {
        return size==0;
    }
    
    public void increaseSize()
    {
        ++size;
    }
    
}