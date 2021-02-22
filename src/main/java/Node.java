class Node<T extends Comparable<T>> {
    T key;
    int height;
    Node<T> left;
    Node<T> right;

    Node(T key) {
        this.key = key;
        height = 1;
        // ???
        left = null;
        right  = null;
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
}