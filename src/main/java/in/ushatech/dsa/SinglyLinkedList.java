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
        if (size == 0)
            return null;

        if (size == 1) {
            Node temp = head;
            head = tail = null;
            --size;
            return temp;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        // temp is pointing at tail now .
        Node result = tail;
        temp.next = null;
        tail = temp;
        --size;
        return result;
    }

    public boolean insert(int data, int index) {
        if (index < 0 || index > size)
            return false;
        Node node = new Node();
        node.value = data;
        if (size == 0) {
            head = tail = node;
            ++size;
            return true;
        }

        Node temp = head;
        for (int i = 1; i < index; ++i) {
            temp = temp.next;
        }
        System.out.println("temp is at " + temp);
        node.next = temp.next;
        temp.next = node;
        ++size;
        return true;
    }

    public Node get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index not correct");
        }
        Node sentinel = new Node();
        sentinel.next = head;
        for (int i = 0; i < index; ++i) {
            sentinel = sentinel.next;
        }
        return sentinel.next;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        return sb.toString();
    }

    public boolean set(int index, int value) {

        if (index < 0 || index >= size)
            return false;
        Node temp = head;
        for (int i = 0; i < index; ++i) {
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    public Node remove(int index) 
    {
        if(size==0 || index<-1 || index >=size) return null;

        Node sentinel = new Node();
        sentinel.next = head;
        for(int i=0 ; i< index ; ++i)
        {
            sentinel=sentinel.next;
        }
        //sentinel is prevNode now for node to be removed 

        Node result = sentinel.next;

        sentinel.next=sentinel.next.next;
        result.next=null;
        --size;
        return result;
    }

    public String rotate(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    }



}