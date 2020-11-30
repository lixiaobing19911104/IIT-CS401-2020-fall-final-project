package Project;

public class BinarySearchTree<T extends Comparable> {
    /**
     * reference to the root of this binary search tree
     */
    protected BSTNode<T> root;

    /**
     * Initializes the bst to empty creating a dummy root node.
     */
    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(T[] arr) {
        for (int j = 1; j <= arr.length; j++) {
            this.add(arr[j - 1]);
        }
    }

    /**
     * Initialized the bst with a given root node
     *
     * @param root A given binary tree node
     */
    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }

    /**
     * returns true if this BST is empty, false otherwise
     *
     * @return boolean value
     */
    public boolean isEmpty() {
        return root == null;
    }

    /////////////////// Your lab assignment starts from here //////////////////

    /**
     * Returns true if this BST contains a node with integer c
     *
     * @param c an integer
     * @return
     */
    public boolean contains(T c) {
        return search(c, root);
    }


    /**
     * A recursive helper function for contains
     * Returns true if the subtree rooted at node contains integer c;
     * Otherwise return false.
     *
     * @param c    A target integer you want to search
     * @param node A binary search tree node
     * @return
     */
    public boolean search(T c, BSTNode node) {
        /* 1. Fill your code here */
        boolean result = true;
        if (node == null) {
            result = false;
           } 
        else {
            if (c.compareTo(node.getInfo()) < 0) {
                result = search(c, node.getLeft());
            } else if (c.compareTo(node.getInfo()) > 0) {
                result = search(c, node.getRight());
            } else {
            }
        }
        
        return result;

        /* 1. End of your code */
    }


    /**
     * Adds integer c to this BST
     *
     * @param c The integer that you want to add
     */
    public void add(T c) {
        root = recAdd(c, root);
    }


    /**
     * The recursive helper function for add.
     * Adds integer c to tree rooted at node; tree retains its BST property.
     *
     * @param c    The integer you want to add
     * @param node A binary tree node
     * @return binary tree node
     */
    public BSTNode recAdd(T c, BSTNode node) {
        /* 2. Fill your code here */
        BSTNode newNode = new BSTNode(c);
        if (node == null) {
            node = new BSTNode(c);
        } else if (node.getLeft() == null && c.compareTo(node.getInfo()) <= 0) {
            node.setLeft(newNode);
        } else if (node.getRight() == null && c.compareTo(node.getInfo()) > 0) {
            node.setRight(newNode);
        } else if (node.getLeft() != null && c.compareTo(node.getInfo()) <= 0) {
            recAdd(c, node.getLeft());
            // Add in left subtree
        } else {
            recAdd(c, node.getRight());
            // Add in right subtree
        }
        return node;
        /* 2. End of your code */
    }


    /**
     * An iterative implementation of add.
     *
     * @param c The integer you want to add
     */
    public void iterAdd(T c) {
        /* 3. Fill your code here */
        if (root == null) {
            root = new BSTNode<T>(c);
            return;
        }
        BSTNode<T> cur = root;
        while (true) {
            T curValue = cur.getInfo();
            if (c.compareTo(curValue) <= 0) {
                if (cur.getLeft() == null) {
                    cur.setLeft(new BSTNode<T>(c));
                    return;
                } else {
                    cur = cur.getLeft();
                }
            } else {
                if (cur.getRight() == null) {
                    cur.setRight(new BSTNode<T>(c));
                    return;
                } else {
                    cur = cur.getRight();
                }
            }
        }


        /* 3. End of your code */
    }

    /**
     * Print the BST in preorder, inorder or postorder
     *
     * @param t A enum type variable which is PREORDER, INORDER or POSTORDER
     */
    public void display(Traversal t) {
        switch (t) {
            case PREORDER:
                preorderDisplay(root);
                break;
            case INORDER:
                inorderDisplay(root);
                break;
            case POSTORDER:
                postorderDisplay(root);
                break;
            default:
                break;
        }
    }

    /**
     * Prints the integers of the subtree whose root is referenced by node.
     * Uses preorder traversal.
     * Can be implemented in a recursive way.
     *
     * @param node
     */
    public void preorderDisplay(BSTNode node) {
        /* 4. Fill your code here */
        if (node != null) {
            System.out.print(" " + node.getInfo() + " ");
            preorderDisplay(node.getLeft());
            preorderDisplay(node.getRight());
        }

        /* 4. End of your code */
    }


    /**
     * Prints the integers of the subtree whose root is referenced by node.
     * Uses inorder traversal.
     * Can be implemented in a recursive way.
     *
     * @param node
     */
    public void inorderDisplay(BSTNode node) {
        /* 5. Fill your code here */
        if (node != null) {
            inorderDisplay(node.getLeft());
            System.out.print(" " + node.getInfo() + " ");
            inorderDisplay(node.getRight());
        }
        /* 5. End of your code */
    }


    /**
     * Prints the integers of the sbutree whose root is referenced by node.
     * uses postorder traversal.
     * Can be implemented in a recursive way.
     *
     * @param node
     */
    public void postorderDisplay(BSTNode node) {
        /* 6. Fill your code here */
        if (node != null) {
            postorderDisplay(node.getLeft());
            postorderDisplay(node.getRight());
            System.out.print(" " + node.getInfo() + " ");
        }
        /* 6. End of your code */
    }
    
    public int searchcount(T c) {
    	return this.searchsteps(c,root);
    }
    
    public int searchsteps(T c, BSTNode node) {
        /* 1. Fill your code here */
        int count=1;
        boolean found=false;
        if (node == null) {   System.out.println (" And the total count times are ");         
        } else {
            if (c.compareTo(node.getInfo()) < 0) {
                count=count+searchsteps(c, node.getLeft());
            } else if (c.compareTo(node.getInfo()) > 0) {
                count=count+searchsteps(c, node.getRight());
            } else {found=true;
            	System.out.println (" And the count times are ");
            }
        }  
    return count;
        /* 1. End of your code */
    }

    /**
     * Returns the maximum depth of this BST.
     * The maximum depth is the number of nodes along the longest path from the root node down
     * to the farthest leaf node.
     *
     * @return
     */
    public int maxDepth() {
        return recMaxDepth(root);
    }

    /**
     * The recursive helper function for mexDepth
     * Returns the max depth of the subtree whose root is referenced by node
     *
     * @param node
     * @return
     */
    private int recMaxDepth(BSTNode node) {
        /* 7. Fill your code here */
        if (node == null) {
            return 0;
        }
        return Integer.max(recMaxDepth(node.getLeft()), recMaxDepth(node.getRight())) + 1;
        /* 7. End of your code */
    }
} 

