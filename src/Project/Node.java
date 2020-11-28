package Project;

/**
 * @author lixiaobing
 * @date 2020-11-28 11:54
 * @Description:
 */
public class Node<T> {
    // Instead of implement a single function as before, You are required to design and implement the whole class.
    // Design and implement your CharNode. It's a link node which contains a char
    // You can define any attributes or methods on your own
    // You will use your CharNode class in CharStack.
    // Filling your code here
    protected T       info;
    protected Node<T> link;

    public Node() {
        this.info = null;
        link      = null;
    }

    public Node(T info) {
        this.info = info;
        link      = null;
    }

    public Node(T info, Node<T> link) {
        this.info = info;
        this.link = link;
    }

    public void setinfo(T info) {
        this.info = info;
    }

    public T getinfo() {
        return info;
    }

    public void setlink(Node<T> link) {
        this.link = link;
    }

    public Node<T> getlink() {
        return link;
    }
}
