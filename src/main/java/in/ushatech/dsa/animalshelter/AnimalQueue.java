package in.ushatech.dsa.animalshelter;
import java.util.*;

public class AnimalQueue 
{
    Queue<Animal> queue;
    int order;
    public AnimalQueue()
    {
        this.queue= new LinkedList<>();
        this.order=0;
    }

    public void enQueue(Animal animal)
    {
        animal.setOrder(order);
        ++order;
        queue.offer(animal);
    }
    
    public Animal deQueueAny()
    {
        return queue.poll();
    }
    // using temporary queue 
    public Cat deQueueCats()
    {
        Queue<Animal> tempQueue = new LinkedList<>();
        while(queue.peek() instanceof Dog)
        {
            tempQueue.offer(queue.poll());
        }
        Cat firstCat = (Cat) queue.poll();
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }
        return firstCat;
    }
    // using temporary stack
    public Dog deQueueDogs()
    {
        Stack<Animal> stack = new Stack<>();
        while(queue.peek() instanceof Cat)
        {
            stack.push(queue.poll());
        }
        Dog result = (Dog) queue.poll();
        while (!stack.isEmpty()) {
            queue.offer((Cat)stack.pop());
        }
        return result;
    }
    
}