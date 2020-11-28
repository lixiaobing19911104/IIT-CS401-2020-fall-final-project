package Project;

/**
 * binary search tree
 *
 * @param <T>
 */
public class BSTNode<T extends Comparable> {
    /**
     * inner information
     */
    private T info;

    /**
     * left child
     */
    private BSTNode left;
    /**
     * right child
     */
    private BSTNode right;

    /**
     * initialize the node
     *
     * @param info
     */
    public BSTNode(T info) {
        this.info = info;
        left      = null;
        right     = null;
    }

    public void setInfo(T info) {
        this.info = info;
    }


    public T getInfo() {
        return this.info;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

}



