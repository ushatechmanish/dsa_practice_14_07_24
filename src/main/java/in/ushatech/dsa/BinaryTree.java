package in.ushatech.dsa;

public class BinaryTree {

    private TreeNode root;

    public void add(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            addRecursive(root, value);
        }
    }

    private void addRecursive(TreeNode current, int value) {
        int currentValue = current.value;
        if (value > currentValue)// will go in right side
        {
            if (current.right == null) {
                current.right = new TreeNode(value);
            }
            addRecursive(current.right, value);
        }
        if (value < currentValue)// will go in left side
        {
            if (current.left == null) {
                current.left = new TreeNode(value);
            }
            addRecursive(current.left, value);
        }
    }

    public void traverseInOrder() {
        traverseInOrderRecursive(root);
    }

    private void traverseInOrderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        traverseInOrderRecursive(node.left);
        System.out.print(node.value + " ");
        traverseInOrderRecursive(node.right);

    }


}
