import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void notLine() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);

        assertTrue(tree.checkRootSubtrees() < 2);
        assertTrue(tree.getHeight() < 6);
    }

    @Test
    void size() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        tree.add(2);
        tree.add(2);
        assertEquals(2, tree.size());
        tree.remove(2);
        assertEquals(1, tree.size());
    }

    @Test
    void isEmpty() {
        Tree<Character> tree = new Tree<>();
        assertTrue(tree.isEmpty());
        tree.add('a');
        assertFalse(tree.isEmpty());
        tree.remove('a');
        assertTrue(tree.isEmpty());
    }

    @Test
    void contains() {
        Tree<String> tree = new Tree<>();
        tree.add("hello");
        assertTrue(tree.contains("hello"));
        assertFalse(tree.contains("helo"));
        tree.remove("hello");
        assertFalse(tree.contains("hello"));
    }

    @Test
    void add() {
        Tree<Integer> tree = new Tree<>();
        assertTrue(tree.add(5));
        assertFalse(tree.add(5));
    }

    @Test
    void remove() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        tree.add(2);
        assertTrue(tree.remove(1));
        assertEquals(1, tree.size());
        assertFalse(tree.remove(3));
        assertEquals(1, tree.size());
    }

    @Test
    void equals() {
        Tree<Integer> tree1 = new Tree<>();
        Tree<Integer> tree2 = new Tree<>();

        tree1.add(1);
        tree1.add(2);
        tree1.add(3);

        tree2.add(1);
        tree2.add(2);
        tree2.add(3);
        assertEquals(tree1, tree2);
        assertEquals(tree2, tree1);

        tree1.remove(2);
        tree2.remove(2);
        assertEquals(tree1, tree2);
        assertEquals(tree2, tree1);
    }

    @Test
    void hash() {
        Tree<Integer> tree1 = new Tree<>();
        Tree<Integer> tree2 = new Tree<>();

        tree1.add(1);
        tree1.add(2);
        tree1.add(3);

        tree2.add(1);
        tree2.add(2);
        tree2.add(3);
        assertEquals(tree1.hashCode(), tree2.hashCode());

        tree1.remove(2);
        tree2.remove(2);
        assertEquals(tree1.hashCode(), tree2.hashCode());
    }
}