package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.ushatech.dsa.linkedlist.CircularlySingleLinkedList;

public class CircularSinglyLinkedListTest {

    @Test
    void testAppend() {
        CircularlySingleLinkedList list = new CircularlySingleLinkedList();
        list.append(10);
        assertEquals("10", list.toString());

        list.append(20);
        assertEquals("10 -> 20", list.toString());

        list.append(30);
        assertEquals("10 -> 20 -> 30", list.toString());
    }

    @Test
    void testPrepend() {
        CircularlySingleLinkedList list = new CircularlySingleLinkedList();
        list.prepend(10);
        assertEquals("10", list.toString());

        list.prepend(20);
        assertEquals("20 -> 10", list.toString());

        list.prepend(30);
        assertEquals("30 -> 20 -> 10", list.toString());
    }

    @Test
    void testAppendAndPrepend() {
        CircularlySingleLinkedList list = new CircularlySingleLinkedList();
        list.append(10);
        list.prepend(5);
        list.append(15);
        list.prepend(1);
        assertEquals("1 -> 5 -> 10 -> 15", list.toString());
    }

    @Test
    void testEmptyList() {
        CircularlySingleLinkedList list = new CircularlySingleLinkedList();
        assertEquals("", list.toString());
    }

    @Test
    void testSingleElementList() {
        CircularlySingleLinkedList list = new CircularlySingleLinkedList();
        list.append(1);
        assertEquals("1", list.toString());

        list.prepend(2);
        assertEquals("2 -> 1", list.toString());
    }

    @Test
    public void testDeleteByValue() {
        CircularlySingleLinkedList list = new CircularlySingleLinkedList();

        // Case 1: Deleting from an empty list
        assertFalse(list.deleteByValue(10), "Deleting from an empty list should return false");

        // Case 2: Deleting the only element in the list
        list.append(1);
        assertTrue(list.deleteByValue(1), "Deleting the only element should return true");
        assertNull(list.head, "Head should be null after deleting the only element");
        assertNull(list.tail, "Tail should be null after deleting the only element");
        assertEquals(0, list.size, "size should be 0 after deleting the only element");

        // Case 3: Deleting an element that does not exist in a single-element list
        list.append(1);
        assertFalse(list.deleteByValue(2), "Deleting a non-existent element should return false");

        // Case 4: Deleting the head in a multi-element list
        list.append(2);
        list.append(3);
        list.append(4);
        assertTrue(list.deleteByValue(1), "Deleting the head should return true");
        assertEquals(2, list.head.value, "New head should be the next element");
        assertEquals(3, list.size, "size should be decremented after deleting the head");

        // Case 5: Deleting the tail in a multi-element list
        assertTrue(list.deleteByValue(4), "Deleting the tail should return true");
        assertEquals(3, list.tail.value, "New tail should be the previous element");
        assertEquals(2, list.size, "size should be decremented after deleting the tail");

        // Case 6: Deleting a middle element
        list.append(5);
        assertTrue(list.deleteByValue(3), "Deleting a middle element should return true");
        assertEquals(5, list.head.next.value, "The next element after head should be the next element in the list");
        assertEquals(2, list.size, "size should be decremented after deleting a middle element");

        // Case 7: Deleting a non-existent element in a multi-element list
        assertFalse(list.deleteByValue(10), "Deleting a non-existent element should return false");

        // Case 8: Check the list integrity after various operations
        list.prepend(1);
        list.append(3);
        assertTrue(list.deleteByValue(2), "Deleting a middle element should return true");
        assertEquals(1, list.head.value, "Head should be the first element");
        assertEquals(3, list.tail.value, "Tail should be the last element");
        assertEquals(3, list.size, "size should be correct after all deletions");
    }

}
