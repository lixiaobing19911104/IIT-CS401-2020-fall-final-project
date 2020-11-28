package Project;

/**
 * @author lixiaobing
 * @date 2020-11-28 11:57
 * @Description:
 */
public class GeneralLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public GeneralLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public void push(T newInfo) {
        /* 1. Fill your code here */
        Node<T> newNode = new Node<T>(newInfo);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setlink(head);
            this.head = newNode;
        }
        /* 1.End of your code here */
    }


    public void append(T newInfo) {
        /* 2. Fill your code here */
        Node<T> newNode = new Node<T>(newInfo);
        if (this.isEmpty()) {
            this.tail = newNode;
            this.head = tail;
        } else {
            tail.setlink(newNode);
            this.tail = newNode;
        }
    }


    // pop the top char from the stack
// Hint
// For you convenience, you are not required to handle exception when poping a empty stack.
// It means when a stack is empty,  do nothing.
    public void pop() throws Exception {
        // 5. Filling your code here
        if (isEmpty()) {
            throw new Exception("Pop attempted on empty stack.");
        } else {
            head = head.getlink();
        }
        // 5. End of code
    }


    //return the char of the top element
    public T top() throws Exception {
        // 6. Filling your code here
        if (isEmpty()) {
            throw new Exception("Pop attempted on empty stack.");
        } else {
            return head.getinfo();
        }
        // 6. End of code
    }

    // return true if the stack is empty, otherwise, return false;
    public boolean isEmpty() {
        // 7. Filling your code here
        return head == null;        // 7. End of code
    }


    // return the number of elements in the stack
    public int size() {
        // 8. Filling your code here
        int a = 0;
        while (!this.isEmpty()) {
            a++;
        }
        return a;
        // 8. End of code
    }

    //  transfer the stack to a string and return it.
    // E.g. From bottom to the top, if the chars in stack are 'a', 'e', 'c', '!'. The return shall be "aec!"
    @Override
    public String toString() {
        // 9. Filling your code here
        int b = 0;
        T[] c = null;
        while (!this.isEmpty()) {
            try {
                c[b++] = this.top();
                this.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(c);
        // 9. End of code
    }

    /**
     * transform array to home-made linked list
     *
     * @param num
     * @param <T>
     * @return
     */
    public static <T> GeneralLinkedList<T> fromArray(T[] num) {
        GeneralLinkedList<T> newList = new GeneralLinkedList<T>();
        for (int i = 0; i < num.length; i++) {
            newList.append(num[i]);
        }
        return newList;
    }

    /**
     * find element from linked list
     *
     * @param element
     * @return
     */
    public boolean find(T element) {
        if (isEmpty()) {
            return false;
        }
        Node<T> curLocation = head;
        int     count       = 0;
        boolean found       = false;
        while (curLocation != null) {
            if (curLocation.getinfo().equals(element)) {
                found = true;
                break;
            }
            curLocation = curLocation.getlink();
            count++;
        }
        if (found) {
            System.out.println("Searching "+ element + " from list is " + count + " times");
        } else {
            System.out.println("There is no such item named " + element);
        }
        return found;
    }


}
