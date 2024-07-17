package in.ushatech.dsa;

public class Node {
    public Node next;
    public int value;

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
