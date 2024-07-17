package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import in.ushatech.dsa.animalshelter.AnimalQueue;
import in.ushatech.dsa.animalshelter.Cat;
import in.ushatech.dsa.animalshelter.Dog;

public class AnimalQueueTest {
    private AnimalQueue animalQueue;

    @BeforeEach
    public void setUp() {
        animalQueue = new AnimalQueue();
    }

    @Test
    public void testEnqueueAndDequeueAny() {
        animalQueue.enQueue(new Cat("Kiki"));
        animalQueue.enQueue(new Dog("Beji"));
        animalQueue.enQueue(new Cat("Kari"));
        
        assertEquals("Kiki", animalQueue.deQueueAny().name(), "First deQueueAny should return Kiki");
        assertEquals("Beji", animalQueue.deQueueAny().name(), "Second deQueueAny should return Beji");
        assertEquals("Kari", animalQueue.deQueueAny().name(), "Third deQueueAny should return Kari");
    }

    @Test
    public void testDequeueCats() {
        animalQueue.enQueue(new Cat("Kiki"));
        animalQueue.enQueue(new Dog("Beji"));
        animalQueue.enQueue(new Cat("Kari"));

        assertEquals("Kiki", animalQueue.deQueueCats().name(), "First deQueueCats should return Kiki");
        assertEquals("Kari", animalQueue.deQueueCats().name(), "Second deQueueCats should return Kari");
        assertNull(animalQueue.deQueueCats(), "Third deQueueCats should return null as no cats are left");
    }

    @Test
    public void testDequeueDogs() {
        animalQueue.enQueue(new Cat("Kiki"));
        animalQueue.enQueue(new Dog("Beji"));
        animalQueue.enQueue(new Cat("Kari"));

        assertEquals("Beji", animalQueue.deQueueDogs().name(), "First deQueueDogs should return Beji");
        assertNull(animalQueue.deQueueDogs(), "Second deQueueDogs should return null as no dogs are left");
    }

    @Test
    public void testMixedDequeue() {
        animalQueue.enQueue(new Cat("Kiki"));
        animalQueue.enQueue(new Dog("Beji"));
        animalQueue.enQueue(new Cat("Kari"));
        animalQueue.enQueue(new Dog("Dexter"));
        animalQueue.enQueue(new Cat("Reki"));

        assertEquals("Kiki", animalQueue.deQueueAny().name(), "First deQueueAny should return Kiki");
        assertEquals("Beji", animalQueue.deQueueDogs().name(), "First deQueueDogs should return Beji");
        assertEquals("Kari", animalQueue.deQueueCats().name(), "First deQueueCats should return Kari");
        assertEquals("Dexter", animalQueue.deQueueAny().name(), "Second deQueueAny should return Dexter");
        assertEquals("Reki", animalQueue.deQueueAny().name(), "Third deQueueAny should return Reki");
    }
}
