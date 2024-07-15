package in.ushatech.dsa;

import java.util.HashSet;
import java.util.Set;

public class LinkedListUtilMethods {
    public LinkedList deleteDups(LinkedList list) {
        // edge case
        if (list == null || list.size <= 1) {
            return list;
        }

        Node head = list.head;
        // keep track of the list size when removing the node

        Node prev = new Node();
        Node current = head;
        prev.next = current;

        Set<Integer> set = new HashSet<>();
        while (current != null) {
            if (!set.add(current.value)) {
                prev.next = current.next;
                current = current.next;
                list.size -= 1;
                continue;
            }

            current = current.next;
            prev = prev.next;
        }
        return list;

    }

    public Node nthToLast(LinkedList list, int number) {
        if (list.size < number)
            return null;

        Node temp = list.head;
        for (int i = 1; temp != null && i <= list.size - 1 - number; ++i) {
            temp = temp.next;
        }

        return temp.next;
    }

    // TODO correct as per the following expectation
    // expected:<[2 -> 1] -> 9 -> 5 -> 10> but was:<[1 -> 2] -> 9 -> 5 -> 10>
    // Basically the items is shifted to 2 ends .
    // What i have implemented is too complex.
    // Since head and tail is already available , it should be used to simplify the
    // solution
    // The test is also to be implemented after completing this .

    // Review the solution video before attempting it
    // https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/lecture/24338298#overview
    LinkedList partition(LinkedList list, int x) // 1 -> 9 -> 5 -> 10 -> 2 [x=4]
    {
        if (list == null || list.size <= 1) // skipped
        {
            System.out.println("Returning list line 6 " + list);
            return list;
        }

        Node prev = new Node();

        Node current = list.head; // current = 1
        prev.next = current; // prev.next -> 1
        // Move prev and current to the node with first number > x

        while (current.value < x) {
            current = current.next;
            prev = prev.next;
        }

        // check if current is last or null, if yes return list as it is
        if (current == null || current == list.tail) // skipped
        {
            return list;
        }

        Node prevNew = current;
        Node currentNew = prevNew.next;

        while (currentNew != null) {
            if (currentNew.value <= 4) {
                Node tempNext = currentNew.next;
                addNextToNode(prev, currentNew);
                currentNew = tempNext;
                continue;
            }

            currentNew = currentNew.next;
            prevNew = prevNew.next;
        }
        return list;
    }

    public void addNextToNode(Node prev, Node newNode) {
        Node next = prev.next;
        prev.next = newNode;
        newNode.next = next;
    }

    public LinkedList sumLists(LinkedList l1, LinkedList l2) {
        LinkedList result = new LinkedList();
        // We will modify the l1 in place
        Node head1 = l1.head;
        Node head2 = l2.head;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int value1 = 0;
            int value2 = 0;
            if (head1 != null) {
                value1 = head1.value;
                head1 = head1.next;
            }

            if (head2 != null) {
                value2 = head2.value;
                head2 = head2.next;
            }

            int sum = value1 + value2 + carry;

            int newDigit = sum % 10;

            carry = sum / 10;

            result.insertNode(newDigit);

        }
        if (carry != 0) {
            result.insertNode(carry);
        }
        return result;
    }

    public Node findIntersection(LinkedList l1, LinkedList l2) {
        l1.traversalLL();
        l2.traversalLL();
        Node head1 = l1.head;
        Node head2 = l2.head;
        int size1 = l1.size;
        int size2 = l2.size;
        int diff = (size1 - size2) > 0 ? (size1 - size2) : (size2 - size1);
        // System.out.println("diff"+diff);
        if (size1 > size2) {
            // System.out.println("moving head1 by "+diff);
            for (int i = 0; i < diff; ++i)
                head1 = head1.next;
        }
        if (size2 > size1) {
            // System.out.println("moving head2 by "+diff);
            for (int i = 0; i < diff; ++i)
                head2 = head2.next;
        }

        // System.out.println(String.format("head1 %d , head2
        // %d",head1.value,head2.value));
        while (head1 != null && head2 != null) {
            if (head1 == head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;

    }

    void addSameNode(LinkedList llA, LinkedList llB, int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        llA.tail.next = newNode;
        llA.tail = newNode;
        llB.tail.next = newNode;
        llB.tail = newNode;
    
      }
      
}
