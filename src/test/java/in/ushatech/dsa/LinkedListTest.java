package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void testSumLists() 
    {
        LinkedListUtilMethods linkedListUtilMethods = new LinkedListUtilMethods();
        LinkedList l1 = new LinkedList();
        l1.insertNode(2);
        l1.insertNode(4);
        l1.insertNode(3);

        LinkedList l2 = new LinkedList();
        l2.insertNode(5);
        l2.insertNode(6);
        l2.insertNode(4);

        LinkedList expected = new LinkedList();
        expected.insertNode(7);
        expected.insertNode(0);
        expected.insertNode(8);

        LinkedList result = linkedListUtilMethods.sumLists(l1, l2);

        assertTrue(expected.toString().equals(result.toString()), "The sum of the linked lists is incorrect");
    }

    @Test
    public void testFindIntersection() {
        // Create two linked lists
        LinkedList llA = new LinkedList();
        llA.insertNode(3);
        llA.insertNode(7);
        llA.insertNode(8);

        LinkedList llB = new LinkedList();
        llB.insertNode(99);
        llB.insertNode(1);

        // Create an intersection
        LinkedListUtilMethods linkedListUtilMethods = new LinkedListUtilMethods();
        linkedListUtilMethods.addSameNode(llA, llB, 10); // Intersection point

        // Find intersection
        Node intersection = linkedListUtilMethods.findIntersection(llA, llB);

        // Assert that intersection is found and the value is correct
        assertNotNull(intersection);
        assertEquals(10, intersection.value);
    }

    @Test
    public void testNoIntersection() {
        // Create two linked lists with no intersection
        LinkedList llA = new LinkedList();
        llA.insertNode(3);
        llA.insertNode(7);
        llA.insertNode(8);

        LinkedList llB = new LinkedList();
        llB.insertNode(99);
        llB.insertNode(1);

        // Find intersection
        LinkedListUtilMethods linkedListUtilMethods = new LinkedListUtilMethods();
        Node intersection = linkedListUtilMethods.findIntersection(llA, llB);

        // Assert that there is no intersection
        assertNull(intersection);
    }
}
