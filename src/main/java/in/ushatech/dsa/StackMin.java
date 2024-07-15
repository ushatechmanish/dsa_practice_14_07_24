package in.ushatech.dsa;

// TODO test Pending
public class StackMin {
  
    Integer min;
    
    Node top;
  
    public StackMin() 
    {
      min=Integer.MAX_VALUE;
      top=null;
    }

    public int min() {
      return min;
    }
    public void push(int value) 
    {
      if(top==null)
      {
          top = new Node(value);
  
      }
      else
      {
          top.next=new Node(value);
      }
      updateMinimum();
    }
  
    public int pop() 
    {
       int result;
      if(top==null)
      {
          result= Integer.MIN_VALUE;
      }
      else
      {
          result = top.value;
          top=top.next;
      }
      
      updateMinimum();
      return result; 
    }
    
    private void updateMinimum()
    {
        if(top==null)
        {
            min=Integer.MAX_VALUE;
        }
        else if(top.value<min)
        {
            min=top.value;
        }
    }
  }