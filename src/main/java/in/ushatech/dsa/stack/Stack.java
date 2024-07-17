package in.ushatech.dsa.stack;

import in.ushatech.dsa.Node;

public class Stack 
{
     Node top;
     int height;

    public Stack() {
        top = null;
        height = 0;
    }
    
     public void push(Node node) {
        node.next = top;
        top = node;
        height++;
    }

    public Node pop() 
    {
        if(top==null)
        {
            return null;
        }
        --height;
        Node poppedNode = top;
        top=top.next;
        return poppedNode;
        
    }

   
}
//TODO : Test to be written