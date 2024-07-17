package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import in.ushatech.dsa.queue.Queue;

public class QueueTest {
    private Queue queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue(5); // Initialize queue with capacity of 5
    }

    @Test
    public void testQueueInitialization() {
        assertTrue(queue.isEmpty(), "Queue should be empty upon initialization");
        assertFalse(queue.isFull(), "Queue should not be full upon initialization");
    }

    @Test
    public void testEnQueue() {
        queue.enQueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
        assertEquals(1, queue.peek(), "Peek should return the first enqueued element");
    }

    @Test
    public void testDeQueue() {
        queue.enQueue(1);
        queue.enQueue(2);
        assertEquals(1, queue.deQueue(), "Dequeue should return the first enqueued element");
        assertEquals(2, queue.peek(), "Peek should return the next element after dequeue");
    }

    @Test
    public void testIsFull() {
        for (int i = 1; i <= 5; i++) {
            queue.enQueue(i);
        }
        assertTrue(queue.isFull(), "Queue should be full after enqueuing 5 elements");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
        queue.enQueue(1);
        queue.deQueue();
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements");
    }

    @Test
    public void testPeek() {
        assertEquals(Integer.MIN_VALUE, queue.peek(), "Peek should return Integer.MIN_VALUE when queue is empty");
        queue.enQueue(1);
        assertEquals(1, queue.peek(), "Peek should return the first enqueued element");
    }

    @Test
    public void testDeQueueEmptyQueue() {
        assertEquals(Integer.MIN_VALUE, queue.deQueue(), "Dequeue should return Integer.MIN_VALUE when queue is empty");
    }

    @Test
    public void testEnQueueFullQueue() {
        for (int i = 1; i <= 5; i++) {
            queue.enQueue(i);
        }
        queue.enQueue(6); // This should not change the queue
        assertEquals(1, queue.peek(), "Peek should return the first element after trying to enqueue into a full queue");
        assertEquals(1, queue.deQueue(), "Dequeue should return the first element after trying to enqueue into a full queue");
    }
}
