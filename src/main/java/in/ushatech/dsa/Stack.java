package in.ushatech.dsa;

public class Stack {
    
    Node top=null;
    
    int height=0;
    
    public Stack(int initialValue)
    {
        top = new Node();
        top.value=initialValue;
        ++height;
    }
    
    
    class Node 
    {
        Node next;
        int value;
    }
}
//TODO : Test to be written