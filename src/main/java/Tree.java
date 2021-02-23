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

    // Вставить ключ key в поддерево с корнем в узле node
    private Node<T> insert(Node<T> node, T key) {
        if (node == null) return new Node<T>(key);

        int comparison = key.compareTo(node.key);
        if (comparison < 0)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);
        return balance(node);
    }

    // Поиск минимального ключа в поддереве с корнем в узле node
    private Node<T> findMin(Node<T> node) {
        return (node.left == null)? node : findMin(node.left);
    }

    // Удаление узла с минимальным ключом из поддерева с корнем в узле node
    private Node<T> removeMin(Node<T> node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        return balance(node);
    }

    // Удаление узла с ключом key из поддерева с корнем node
    private Node<T> remove(Node<T> node, T key) {
        if (node == null) return null;

        int comparison = key.compareTo(node.key);
        if (comparison < 0) {
            node.left = remove(node.left, key);
        } else if (comparison > 0) {
            node.right = remove(node.right, key);
        } else {
            Node<T> left = node.left;
            Node<T> right = node.right;
            // ДОДЕЛАТЬ
        }
        // ДОДЕЛАТЬ
        return null;
    }

    private Node<T> find(T key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
