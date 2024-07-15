package in.ushatech.dsa;

// sentinel node is not required here as we already have prev Node as tail
public class CSLinkedList {
    Node head;
    Node tail;
    int size;

    public CSLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void append(int value) {
        if (size == 0) {
            head = tail = getSingleNode(value);
            ++size;
            return;
        }
        Node sentinel = getSentinelNode();
        Node newNode = new Node(value);
        newNode.next = head;
        tail.next = newNode;
        tail = tail.next;
        ++size;
    }

    public void prepend(int value) // expected: <1 -> 2 -> 3> but was: <3 -> 1>
    {
        if (size == 0) {
            head = tail = getSingleNode(value);
            ++size;
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head;
        tail.next = newNode;
        head = newNode; // this was missed
        ++size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.value);
            if (temp.next != head) {
                sb.append(" -> ");
            } else {
                break; // important to avoid infinite loop
            }
            temp = temp.next;
        }
        return sb.toString();
    }

    private Node getSentinelNode() {
        Node sentinel = new Node(0);
        sentinel.next = head;
        return sentinel;
    }

    private Node getSingleNode(int value) {
        Node singleNode = new Node(value);
        singleNode.next = singleNode;
        return singleNode;

    }

    public boolean deleteByValue(int value) 
    {
        if(size == 0) return false;
        if(size == 1 && head.value == value) {
            head = tail = null;
            size--;
            return true;
        }
        
        if(size == 1 && head.value != value) {
            return false;
        }
        
        // At least 2 nodes are there with head != tail
        if(head.value == value) {
            Node nodeDeleted = head;
            head = head.next;
            tail.next = head;
            nodeDeleted.next = null;
            --size;
            return true;
        }
        
        if(tail.value == value) {
            Node nodeDeleted = tail;
            // Reach to the prevNode to tail
            Node temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
            nodeDeleted.next = null;
            --size;
            return true;
        }
        
        // For middle nodes
        Node prevNode = head;
        Node current = head.next;
        while(current != head && current.value != value) {
            prevNode = current;
            current = current.next;
        }
        if(current == head) return false;  // Value not found in the list
        
        prevNode.next = current.next;
        current.next = null;
        --size;
        return true;
    }
    public int countNodes() {
        return size;
    }
}
