import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Tree<T extends Comparable<T>> implements Set<T> {

    private Node<T> root = null;
    private int size = 0;

    private Node<T> rotateRight(Node<T> node) {
        Node<T> left = node.left;
        node.left = left.right;
        left.right = node;
        node.fixHeight();
        left.fixHeight();
        return left;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> right = node.right;
        node.right = right.left;
        right.left = node;
        node.fixHeight();
        right.fixHeight();
        return right;
    }

    private Node<T> balance(Node<T> node) {
        node.fixHeight();

        if (node.balanceFactor() == 2) {
            if (node.right.balanceFactor() < 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        if (node.balanceFactor() == -2) {
            if (node.left.balanceFactor() > 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        return node;
    }

    private Node<T> insert(Node<T> root, T key) {
        // Вставить ключ k в дерево с корнем root
        if (root == null) return new Node<T>(key);

        int comparison = key.compareTo(root.key);
        if (comparison < 0)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return balance(root);
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }
}
