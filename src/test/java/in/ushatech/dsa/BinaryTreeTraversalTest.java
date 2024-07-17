package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BinaryTreeTraversalTest {

    private BinaryTreeTraversal traversal;

    @BeforeEach
    public void setUp() {
        traversal = new BinaryTreeTraversal();
    }

    @Test
    public void testBinaryTreeTraversalSingleNode() {
        TreeNode root = new TreeNode(1);
        List<Integer> result = traversal.inOrderTraversal(root);
        assertEquals(List.of(1), result, "Inorder traversal of a single node should return the node itself");
    }

    @Test
    public void testBinaryTreeTraversalLeftSkewedTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);

        List<Integer> result = traversal.inOrderTraversal(root);
        assertEquals(List.of(1, 2, 3), result, "Inorder traversal of a left-skewed tree should return nodes in ascending order");
    }

    @Test
    public void testBinaryTreeTraversalRightSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        List<Integer> result = traversal.inOrderTraversal(root);
        assertEquals(List.of(1, 2, 3), result, "Inorder traversal of a right-skewed tree should return nodes in ascending order");
    }

    @Test
    public void testBinaryTreeTraversalCompleteTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = traversal.inOrderTraversal(root);
        assertEquals(List.of(4, 2, 5, 1, 6, 3, 7), result, "Inorder traversal of a complete tree should return nodes in correct inorder sequence");
    }

    @Test
    public void testBinaryTreeTraversalEmptyTree() {
        TreeNode root = null;
        List<Integer> result = traversal.inOrderTraversal(root);
        assertEquals(List.of(), result, "Inorder traversal of an empty tree should return an empty list");
    }
}
