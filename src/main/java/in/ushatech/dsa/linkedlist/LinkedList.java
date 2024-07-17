package in.ushatech.dsa.linkedlist;

import in.ushatech.dsa.Node;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;
  
    public void createLL(int nodeValue) {
      Node newNode = new Node();
      newNode.value = nodeValue;
      newNode.next = null;
      head = newNode;
      tail = newNode;
      size = 1;
    }
  
    public void insertNode(int nodeValue) {
      if (head == null) {
        createLL(nodeValue);
        return;
      }
    
      Node newNode = new Node();
      newNode.value = nodeValue;
      newNode.next = null;
      tail.next = newNode;
      tail = newNode;
      size++;
    }
  
    public void traversalLL() {
      Node tempNode = head;
      for (int i =0; i<size; i++) {
        System.out.print(tempNode.value);
        if (i != size -1) {
          System.out.print(" -> ");
        }
        tempNode = tempNode.next;
      }
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        Node tempNode = head;
      for (int i =0; i<size; i++) {
        sb.append(tempNode.value);
        if (i != size -1) {
          sb.append(" -> ");
        }
        tempNode = tempNode.next;
        
      }
      return sb.toString();
    }

    public int deQueue() 
    {
      if(size==0)
      {
        return Integer.MIN_VALUE;
      }

        Node newHead=head.next;
        int result = head.value;
        head.next=null;
        head=newHead;
        --size;
        return result;
    }
  
  }
