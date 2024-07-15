package in.ushatech.dsa;

class Stack 
{
    private Node peak;
    private int length;

    public Stack() {
        this.peak = null;
        this.length = 0;
    }

    public void push(int value) 
    {
        Node newNode = new Node(value);
        ++length;
        if(peak==null)
        {
            peak = newNode;
            return;
        }
        
        peak.next=newNode;
        peak=peak.next;
    }
    
    // For demonstration purposes
    public int getPeakValue() {
        if (peak != null) {
            return peak.value;
        }
        return -1; // Return a dummy value if the stack is empty
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(10);
        System.out.println(stack.getPeakValue());  // Outputs: 10
    }

    
}
//TODO : Test to be written