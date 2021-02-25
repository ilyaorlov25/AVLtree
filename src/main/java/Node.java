import java.util.Objects;

class Node<T extends Comparable<T>> {
    T key;
    int height;
    Node<T> left;
    Node<T> right;

    Node(T key) {
        this.key = key;
        height = 1;
    }

    int balanceFactor() {
        int heightLeft = (left != null) ? left.height : 0;
        int heightRight = (right != null) ? right.height : 0;
        return heightRight - heightLeft;
    }

    void fixHeight() {
        int heightLeft = (left != null) ? left.height : 0;
        int heightRight = (right != null) ? right.height : 0;
        this.height = Math.max(heightLeft, heightRight) + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return height == node.height &&
                Objects.equals(key, node.key) &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, height, left, right);
    }
}