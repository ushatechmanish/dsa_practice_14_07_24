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
}
