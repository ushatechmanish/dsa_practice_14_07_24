package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import in.ushatech.dsa.binarysearch.BinarySearchTree;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    public void testInsert() {
        bst.insert(10);
        assertNotNull(bst.root);
        assertEquals(10, bst.root.value);

        bst.insert(5);
        assertNotNull(bst.root.left);
        assertEquals(5, bst.root.left.value);

        bst.insert(15);
        assertNotNull(bst.root.right);
        assertEquals(15, bst.root.right.value);

        bst.insert(7);
        assertNotNull(bst.root.left.right);
        assertEquals(7, bst.root.left.right.value);
    }


    @Test
    public void testInsertNodeIterative() {
        bst.insertNodeIterative(10);
        assertNotNull(bst.root);
        assertEquals(10, bst.root.value);

        bst.insertNodeIterative(5);
        assertNotNull(bst.root.left);
        assertEquals(5, bst.root.left.value);

        bst.insertNodeIterative(15);
        assertNotNull(bst.root.right);
        assertEquals(15, bst.root.right.value);

        bst.insertNodeIterative(7);
        assertNotNull(bst.root.left.right);
        assertEquals(7, bst.root.left.right.value);
    }

}
