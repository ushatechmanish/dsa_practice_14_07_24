package in.ushatech.dsa.binarysearch;

import java.util.Stack;

import in.ushatech.dsa.linkedlist.LinkedList;
import in.ushatech.dsa.queue.Queue;

public class BinarySearchTree {
    public BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        // insert(root, value); This will not update the root hence the test will fail
        root = insert(root, value);
    }

    public void insertNodeIterative(int value) {
        BinaryNode node = new BinaryNode();
        node.value = value;
        if (root == null) {
            root = node;
            return;
        }
        BinaryNode parent = null;
        BinaryNode current = root;
        while (current != null) {
            if (value < current.value) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        if (value < parent.value) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return;

    }

    private BinaryNode insert(BinaryNode current, int value) {
        // root of the new BinarySearhTree will be returned
        if (current == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            return newNode;
        }

        if (value > current.value) {
            current.right = insert(current.right, value);
            return current;
        }

        if (value < current.value) {
            current.left = insert(current.left, value);
            return current;
        }
        // return null; this will break the code
        return current;
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(BinaryNode root) {
        if (root == null)
            return;
        java.util.Queue<BinaryNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryNode current = queue.poll();
            System.out.println(current.value);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }

        }
    }

    public BinaryNode search(int value) {
        return search(root, value);
    }

    public BinaryNode search(BinaryNode root, int value) {
        if (root == null)
            return null;
        if (root.value == value) {
            return root;
        }

        if (root.value < value)
            return search(root.right, value);
        if (root.value > value)
            return search(root.left, value);

        return null;
    }

    // TODO 
    public BinaryNode deleteNode(BinaryNode root, int value) 
    {
        return null;
    }

}
