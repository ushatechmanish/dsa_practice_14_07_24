package in.ushatech.dsa;

public class TreeNode 
{
    public TreeNode left;
    public TreeNode right;
    public int value;
    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public TreeNode( int value) {

        this.value = value;
    }
    
}
