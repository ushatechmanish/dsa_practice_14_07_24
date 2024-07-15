package in.ushatech.dsa;

// sentinel node is not required here as we already have prev Node as tail
public class CSLinkedList {
    Node head;
    Node tail;
    int size;

    public CSLinkedList() {
        head=null;
        tail=null;
        size=0;
    }

    public void append(int value) 
    {
        if(size==0)
        {
            head=tail=getSingleNode(value);
            ++size;
            return;
        }
        Node sentinel = getSentinelNode();
        Node newNode = new Node(value);
        newNode.next=head;
        tail.next=newNode;
        tail=tail.next;
        ++size;
    }

    public void prepend(int value)  // expected: <1 -> 2 -> 3> but was: <3 -> 1>
    {
        if(size==0)
        {
            head=tail=getSingleNode(value);
            ++size;
            return;
        }
        Node newNode = new Node(value);
        newNode.next=head;
        tail.next = newNode;
        head=newNode; // this was missed 
        ++size;
    }

    @Override
    public String toString() 
    {
        StringBuffer sb = new StringBuffer();
        Node temp = head;
        while(temp!=null)
        {
            sb.append(temp.value);
            if(temp.next!=head)
            {
                sb.append(" -> ");
            }
            else
            {
                break; // important to avoid infinite loop
            }
            temp=temp.next;
        }
        return sb.toString();
    }
    
    private Node getSentinelNode()
    {
        Node sentinel = new Node(0);
        sentinel.next=head;
        return sentinel;
    }
    
    private Node getSingleNode(int value)
    {
        Node singleNode = new Node(value);
        singleNode.next=singleNode;
        return singleNode;
        
    }
}
