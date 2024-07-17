package in.ushatech.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
    List<Stack<Integer>> list ;
    int threshold;

    public SetOfStacks(int stackCapacityThreshold) {
        this.list = new ArrayList<>();
        this.threshold = stackCapacityThreshold;
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public boolean isFull()
    {
        return false;
    }

    public int pop()
    {
        if(isEmpty()) 
        return Integer.MIN_VALUE;

        Stack<Integer> lastStack =  getLastStack();
        int result = lastStack.pop();

        if(lastStack.isEmpty())
        {
            list.remove(list.size()-1);
        }
        return result;
    }


    public void push(int value)
    {
        // if lastStack is full add a new stack and add number
        if(isEmpty() || isLastStackFull())
        {
            list.add(new Stack<>());
        }
        Stack<Integer> lastStack = getLastStack();
        lastStack.push(value);

    }

    private Stack<Integer> getLastStack() 
    {
        if(isEmpty()) return null;

        return list.get(list.size()-1);
    }

    private boolean isLastStackFull() {
        Stack<Integer> lastStack = getLastStack();
        return lastStack != null && lastStack.size() == threshold;
    }

    public int popAt(int stackIndex) {
        if (stackIndex < 0 || stackIndex >= list.size()) {
            throw new IndexOutOfBoundsException("Invalid stack index");
        }

        Stack<Integer> stack = list.get(stackIndex);
        int result = stack.pop();

        // If the stack becomes empty, remove it
        if (stack.isEmpty()) {
            list.remove(stackIndex);
        } else {
            // Shift elements from the subsequent stacks
            shiftLeft(stackIndex);
        }

        return result;
    }

    private void shiftLeft(int stackIndex) 
    {
        for (int i = stackIndex; i < list.size() - 1; i++) {
            Stack<Integer> currentStack = list.get(i);
            Stack<Integer> nextStack = list.get(i + 1);
            currentStack.push(nextStack.remove(0));

            if (nextStack.isEmpty()) {
                list.remove(i + 1);
            }
        }

        // If the last stack becomes empty after shifting, remove it
        if (getLastStack() != null && getLastStack().isEmpty()) {
            list.remove(list.size() - 1);
        }
    }    
}
