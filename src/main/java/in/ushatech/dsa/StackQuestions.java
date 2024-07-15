package in.ushatech.dsa;

public class StackQuestions {
    
    //TODO write test 
    public static boolean isBalanced(String expression) // {[()]}
    {
        System.out.println(expression);
        // edge case 
        if(expression.isEmpty()) return true;
        java.util.Stack<Character> stack = new java.util.Stack<>();
        String startParentheses="{[(";
        String endParentheses="}])";
        
        for(char c : expression.toCharArray())
        {
            System.out.println("c is "+(char) c);
            int startIndex = startParentheses.indexOf(c);
            System.out.println("startIndex is "+startIndex);
            int endIndex = endParentheses.indexOf(c);
            System.out.println("endIndex is "+endIndex);
            if(startIndex<0 && endIndex<0) continue;// no action
            // if starting parentheses is present , push in the stack
            if(startIndex>=0) 
            {
                    stack.push(c);
                    System.out.println("pushed"+(char) c);
            }
            else
            {
                // if stack is empty or the counterpart is not present , return false 
                if(stack.isEmpty()) return false;
             
                // Match if the counterpart is present   
                if(endIndex==startParentheses.indexOf(stack.peek()))
                {
                    System.out.println("endIndex"+endIndex);
                    System.out.println("startParentheses.indexOf(stack.peek())"+startParentheses.indexOf(stack.peek()));
                    int popped = stack.pop();
                    System.out.println("popped"+(char)popped);
                }
            }

            
        }
        
        return stack.isEmpty();
    }
}
