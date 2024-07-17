package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetOfStacksTest {
    private SetOfStacks setOfStacks;

    @BeforeEach
    public void setUp() {
        setOfStacks = new SetOfStacks(3); // Initialize SetOfStacks with a threshold of 3
    }

    @Test
    public void testIsEmpty() {
        assertTrue(setOfStacks.isEmpty(), "SetOfStacks should be empty initially");
    }

    @Test
    public void testPushAndPop() {
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        assertEquals(5, setOfStacks.pop(), "Pop should return the last pushed element (5)");
        assertEquals(4, setOfStacks.pop(), "Pop should return the next last pushed element (4)");
        assertEquals(3, setOfStacks.pop(), "Pop should return the next last pushed element (3)");
        assertEquals(2, setOfStacks.pop(), "Pop should return the next last pushed element (2)");
        assertEquals(1, setOfStacks.pop(), "Pop should return the next last pushed element (1)");
        assertEquals(Integer.MIN_VALUE, setOfStacks.pop(), "Pop should return Integer.MIN_VALUE when the stack is empty");
    }

    @Test
    public void testPopAt() {
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        
        assertEquals(3, setOfStacks.popAt(0), "PopAt(0) should return the last element of the first stack (3)");
        assertEquals(4, setOfStacks.popAt(0), "PopAt(0) should return the first element of the second stack after shifting (4)");
        assertEquals(5, setOfStacks.pop(), "Pop should return the remaining element (5)");
        assertEquals(2, setOfStacks.pop(), "Pop should return the remaining element (2)");
        assertEquals(1, setOfStacks.pop(), "Pop should return the remaining element (1)");
    }

    @Test
    public void testPopAtWithIndexOutOfBounds() {
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            setOfStacks.popAt(1);
        }, "PopAt with an invalid index should throw IndexOutOfBoundsException");
    }

    @Test
    public void testIsFull() {
        assertFalse(setOfStacks.isFull(), "isFull should return false, as it is not used meaningfully in the current implementation");
    }

    @Test
    public void testPopOnEmptySetOfStacks() {
        assertEquals(Integer.MIN_VALUE, setOfStacks.pop(), "Pop should return Integer.MIN_VALUE when SetOfStacks is empty");
    }
}
