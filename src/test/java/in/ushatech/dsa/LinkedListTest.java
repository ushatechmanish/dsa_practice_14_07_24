package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinkedListTest {
    
    @Test
    public void deleteDups()
    {
        LinkedList list = new LinkedList();
        list.createLL(1);
        list.insertNode(2);
        list.insertNode(1);
        list.insertNode(3);
        var linkedListUtilMethods = new LinkedListUtilMethods();
        LinkedList uniqueList = linkedListUtilMethods.deleteDups(list);
        assertEquals("1 -> 2 -> 3",uniqueList.toString());
    }

    @Test
    public void nthToLast()
    {
        LinkedList list = new LinkedList();
        list.createLL(1);
        list.insertNode(2);
        list.insertNode(1);
        list.insertNode(3);
        var linkedListUtilMethods = new LinkedListUtilMethods();
        Node nthToLastNode = linkedListUtilMethods.nthToLast(list,2);
        assertEquals(1,nthToLastNode.value);
    }
}