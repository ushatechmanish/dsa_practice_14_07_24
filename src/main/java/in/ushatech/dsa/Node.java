package in.ushatech.dsa;

public class Node {
    Node next;
    int value;

    public Node()
    {
        
    }
    public Node(int value)
    {
        this.value=value;
    }
    @Override
    public String toString() {
        return "Node [next=" + next + ", value=" + value + "]";
    }
    
}
