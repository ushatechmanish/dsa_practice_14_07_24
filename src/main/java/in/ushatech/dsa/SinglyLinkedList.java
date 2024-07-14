package in.ushatech.dsa;

public class SinglyLinkedList {
    int size;
    Node head;
    Node tail;

    public Node push(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        increaseSize();
        return head;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void increaseSize() {
        ++size;
    }

    public Node pop() {
        if(size==0) return null;
        
        if(size==1)
        {
            Node temp = head;
            head=tail=null;
            --size;
            return temp;
        }
        
        Node temp = head ;
        while(temp.next!=tail)
        {
            temp=temp.next;
        }
        // temp is pointing at tail now . 
        Node result= tail;
        temp.next=null;
        tail=temp;
        --size;
        return result;       
      }
    

}