import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }

    @Test
    void add() {
        Tree<Integer> tree = new Tree<>();
        assertTrue(tree.add(5));
        assertFalse(tree.add(5));
    }

    @Test
    void remove() {
    }
}