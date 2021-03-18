package algorithm.btree;

public class RBTreeNode {
    private final boolean RED = false;
    private final boolean BLACK = false;
    private int key;
    private boolean color;
    private RBTreeNode left;
    private RBTreeNode right;
    private RBTreeNode parent;


    public boolean isRED() {
        return RED;
    }

    public boolean isBLACK() {
        return BLACK;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public RBTreeNode getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode left) {
        this.left = left;
    }

    public RBTreeNode getRight() {
        return right;
    }

    public void setRight(RBTreeNode right) {
        this.right = right;
    }

    public RBTreeNode getParent() {
        return parent;
    }

    public void setParent(RBTreeNode parent) {
        this.parent = parent;
    }
}
