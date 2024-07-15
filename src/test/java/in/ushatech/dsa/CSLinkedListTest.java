package in.ushatech.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CSLinkedListTest {
    
    @Test
    void testAppend() {
        CSLinkedList list = new CSLinkedList();
        list.append(10);
        assertEquals("10", list.toString());
        
        list.append(20);
        assertEquals("10 -> 20", list.toString());
        
        list.append(30);
        assertEquals("10 -> 20 -> 30", list.toString());
    }
    
    @Test
    void testPrepend() {
        CSLinkedList list = new CSLinkedList();
        list.prepend(10);
        assertEquals("10", list.toString());
        
        list.prepend(20);
        assertEquals("20 -> 10", list.toString());
        
        list.prepend(30);
        assertEquals("30 -> 20 -> 10", list.toString());
    }
    
    @Test
    void testAppendAndPrepend() {
        CSLinkedList list = new CSLinkedList();
        list.append(10);
        list.prepend(5);
        list.append(15);
        list.prepend(1);
        assertEquals("1 -> 5 -> 10 -> 15", list.toString());
    }
    
    @Test
    void testEmptyList() {
        CSLinkedList list = new CSLinkedList();
        assertEquals("", list.toString());
    }

    @Test
    void testSingleElementList() {
        CSLinkedList list = new CSLinkedList();
        list.append(1);
        assertEquals("1", list.toString());
        
        list.prepend(2);
        assertEquals("2 -> 1", list.toString());
    }
}
