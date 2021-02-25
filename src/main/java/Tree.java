import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Tree<T extends Comparable<T>> implements Set<T> {

    private Node<T> root = null;
    private int size = 0;
    private boolean changed = false;

    // Правый поворот
    private Node<T> rotateRight(Node<T> node) {
        Node<T> left = node.left;
        node.left = left.right;
        left.right = node;
        node.fixHeight();
        left.fixHeight();
        return left;
    }

    // Левый поворот
    private Node<T> rotateLeft(Node<T> node) {
        Node<T> right = node.right;
        node.right = right.left;
        right.left = node;
        node.fixHeight();
        right.fixHeight();
        return right;
    }

    // Балансировка поддерева с корнем в узле node
    // (когда высоты поддеревьев различаются на 2)
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
        if (node == null) {
            changed = true;
            size++;
            return new Node<T>(key);
        }

        int comparison = key.compareTo(node.key);
        if (comparison < 0)
            node.left = insert(node.left, key);
        else if (comparison > 0)
            node.right = insert(node.right, key);
        else return node;

        return balance(node);
    }

    // Поиск узла с ключом key в поддереве с корнем в узле node
    private Node<T> find(Node<T> node, T key) {
        if (node == null) return null;

        int comparison = key.compareTo(node.key);
        if (comparison > 0)
            return find(node.right, key);
        else if (comparison < 0)
            return find(node.left, key);
        else
            return node;
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
        Node<T> found = find(node, key);
        if (found == null) {
            return null;
        } else {
            changed = true;
            size--;
            if (found.right == null) return found.left;
            if (found.left == null) return found.right;
            Node<T> temp = found;
            found = findMin(temp.right);
            found.right = removeMin(temp.right);
            found.left = temp.left;
            return balance(found);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        @SuppressWarnings("unchecked")
        T t = (T) o;
        Node<T> node = find(root, t);
        return node != null && t.compareTo(node.key) == 0;
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
        changed = false;
        root = insert(root, t);
        return changed;
    }

    @Override
    public boolean remove(Object o) {
        @SuppressWarnings("unchecked")
        T t = (T) o;
        changed = false;
        root = remove(root, t);
        return changed;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return size == tree.size &&
                Objects.equals(root, tree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root, size);
    }

    public int checkRootSubtrees() {
        return Math.abs(root.balanceFactor());
    }

    public int getHeight() {
        return root.height;
    }
}
