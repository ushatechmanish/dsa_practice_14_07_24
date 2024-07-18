package in.ushatech.dsa;

public class BinarySearchTree 
{
    BinaryNode root;

    public BinarySearchTree()
    {
        root=null;
    }
    public void insertNodeIterative(int value)
    {
        BinaryNode node = new BinaryNode();
        node.value=value;
        if(root==null)
        {
            root=node;
            return;
        }
        BinaryNode parent =null;
        BinaryNode current = root;
        while (current!=null) 
        {
            if(value<current.value)
            {
                parent=current;
                current=current.left;
            }
            else
            {
                parent=current;
                current=current.right;
            }            
        }
        if(value<parent.value)
            {
                parent.left=node;
            }
            else
            {
                parent.right=node;
            }   
            return;

    }
    
    
}
