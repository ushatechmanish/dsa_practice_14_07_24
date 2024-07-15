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
    // Since head and tail is already available , it should be used to simplify the solution 
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
}
