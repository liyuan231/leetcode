//package algorithm.btree;
//
//public class RBTree {
//    RBTreeNode root;
//    private final boolean RED = false;
//    private final boolean BLACK = true;
//
//    public RBTreeNode query(int key) {
//        RBTreeNode tmp = root;
//        while (tmp != null) {
//            if (tmp.getKey() == key) {
//                return tmp;
//            } else if (tmp.getKey() > key) {
//                tmp = tmp.getLeft();
//            } else {
//                tmp = tmp.getRight();
//            }
//        }
//        return null;
//    }
//
//    public void insert(int key) {
//        RBTreeNode node = new RBTreeNode();
//        if (root == null) {
//            root = node;
//            node.setColor(BLACK);
//            return;
//        }
//        RBTreeNode parent = root;
//        RBTreeNode son = null;
//        if (key <= parent.getKey()) {
//            son = parent.getLeft();
//        } else {
//            son = parent.getRight();
//        }
//        while (son != null) {
//            parent = son;
//            if (key <= parent.getKey()) {
//                son = parent.getLeft();
//            } else {
//                son = parent.getRight();
//            }
//        }
//        if (key <= parent.getKey()) {
//            parent.setLeft(node);
//        } else {
//            parent.setRight(node);
//        }
//        node.setParent(parent);
//        insertFix(node);
//    }
//
//    private void insertFix(RBTreeNode node) {
//        RBTreeNode father, grandFather;
//        while ((father = node.getParent()) != null && father.isColor() == RED) {
//            grandFather = father.getParent();
//            if (grandFather.getLeft() == father) {//F为G的左儿子的情况
//                RBTreeNode uncle = grandFather.getRight();
//                if (uncle != null && uncle.isColor() == RED) {
//                    setBlack(father);
//                    setBlack(uncle);
//                    setRed(grandFather);
//                    node = grandFather;
//                    continue;
//                }
//                if (node == father.getRight()) {
//                    leftRotate(father);
//                    RBTreeNode tmp = node;
//                    node = father;
//                    father = tmp;
//                }
//                setBlack(father);
//                setRed(grandFather);
//                rightRotate(grandFather);
//            } else {//F为G右儿子情况
//                RBTreeNode uncle = grandFather.getLeft();
//                if (uncle != null && uncle.isColor() == RED) {
//                    setBlack(father);
//                    setBlack(uncle);
//                    setRed(grandFather);
//                    node = grandFather;
//                    continue;
//                }
//                if (node == father.getLeft()) {
//                    rightRotate(father);
//                    RBTreeNode tmp = node;
//                    node = father;
//                    father = tmp;
//                }
//                setBlack(father);
//                setRed(grandFather);
//                leftRotate(grandFather);
//            }
//        }
//        setBlack(root);
//    }
//
//    public void delete(int key) {
//        delete(query(key));
//    }
//
//    private void delete(RBTreeNode node) {
//        if (node == null) {
//            return;
//        }
//        if (node.getLeft() != null && node.getRight() != null) {
//            RBTreeNode replaceNode = node;
//            RBTreeNode tmp = node.getRight();
//            while (tmp != null) {
//                replaceNode = tmp;
//                tmp = tmp.getLeft();
//            }
//            int t = replaceNode.getKey();
//            replaceNode.setKey(node.getKey());
//            node.setKey(t);
//            delete(replaceNode);
//            return;
//        }
//        RBTreeNode replaceNode = null;
//
//    }
//
//}
