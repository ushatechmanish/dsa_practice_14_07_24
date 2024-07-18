
package in.ushatech.dsa;

import java.util.*;

public class BinaryTreeTraversal {

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        // while(current!=null) This will not continue once it has once last node .
        // we should not push root in the stack as it is not the first element to be printed
        while (current != null || !stack.isEmpty()) {// since for the last leftmost element there is not right element , the next
            // element will be picked up from the stack
            // first reach left most node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // All leftmost nodes have been put in the stack .
            // current must be null now
            current = stack.pop(); // take out the first element to be printed or on the second iteration pick the parent 
            list.add(current.value);

            // Now right member turn
            current = current.right; // which will be null for the last element

        }

        return list;
    }

    public List<Integer> preOrderTraversal(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        // since we are at the correct position and need to print root first
        Stack<TreeNode> stack = new Stack<>();
        
        
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop();
            list.add(current.value);
            
            // push the 2 nodes in the reverse direction as the last will come first 
            if(current.right!=null)
            stack.push(current.right);
            
            if(current.left!=null)
            stack.push(current.left);
        }
        
        return list;
    }
    //TODO practice these methods again
    public List<Integer> postOrderTraversal(TreeNode root) 
    {
         List<Integer> preOrderList = inOrderTraversal(root);
         Collections.reverse(preOrderList);
         return preOrderList;
    }
}
