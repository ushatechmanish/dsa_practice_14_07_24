package in.ushatech.dsa;

public class BinaryTree {

    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            addRecursive(root, value);
        }
    }

    private void addRecursive(Node current, int value) {
        int currentValue = current.value;
        if (value > currentValue)// will go in right side
        {
            if (current.right == null) {
                current.right = new Node(value);
            }
            addRecursive(current.right, value);
        }
        if (value < currentValue)// will go in left side
        {
            if (current.left == null) {
                current.left = new Node(value);
            }
            addRecursive(current.left, value);
        }
    }

    public void traverseInOrder() {
        traverseInOrderRecursive(root);
    }

    private void traverseInOrderRecursive(Node node) {
        if (node == null) {
            return;
        }
        traverseInOrderRecursive(node.left);
        System.out.print(node.value + " ");
        traverseInOrderRecursive(node.right);

    }

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

}
