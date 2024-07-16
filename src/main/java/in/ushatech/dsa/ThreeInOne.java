package in.ushatech.dsa;

import java.util.Arrays;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5132864#overview
public class ThreeInOne{
  private int numberOfStacks = 3;
  private int stackCapacity;
  private int[] values;
  private int[] sizes;

  public ThreeInOne(int stackCapacity) 
  {
    this.stackCapacity=stackCapacity;
    values= new int[stackCapacity*numberOfStacks];
    sizes= new int[numberOfStacks];
    Arrays.fill(values, Integer.MIN_VALUE);
  }

  
  public boolean isFull(int stackNum) {
    return sizes[stackNum]==stackCapacity;
  }

  public boolean isEmpty(int stackNum) {
      return sizes[stackNum]==0;
  }

  // indexOfTop - this is helper method for push, pop and peek methods

  private int indexOfTop(int stackNum) 
  {
    int offset = stackNum*stackCapacity;
    int size = sizes[stackNum];
    return values[offset+size-1];
  }

  // push
  public void push(int stackNum, int value) 
  {
    if(isFull(stackNum))
    {
       return;
    }
    sizes[stackNum]++;
    values[indexOfTop(stackNum)]=value;
    
  }

  // pop
 public int pop(int stackNum) 
  {
    if(isEmpty(stackNum)) 
    {
      return Integer.MIN_VALUE;
    }
    int result = values[indexOfTop(stackNum)];
    values[indexOfTop(stackNum)]=Integer.MIN_VALUE;
    sizes[stackNum]--;
    return result;
  }

  // peek

  public int peek(int stackNum) 
  {
    if(isEmpty(stackNum)) return Integer.MIN_VALUE;
    return values[indexOfTop(stackNum)];
  }

}

  