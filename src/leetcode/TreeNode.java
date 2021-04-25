package leetcode;

import java.util.Scanner;

public class TreeNode {
    private static Scanner input = new Scanner(System.in);
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    public static TreeNode create() {
        int v = input.nextInt();
        if (v == -1) {
            return null;
        }
        TreeNode treeNode = new TreeNode(v);
        treeNode.left = create();
        treeNode.right = create();
        return treeNode;
    }

    public static TreeNode create(Integer[] array) {
        return createNode(array, 0);
    }

    private static TreeNode createNode(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(array[index]);
        root.left = createNode(array, 2 * index + 1);
        root.right = createNode(array, 2 * index + 2);
        return root;
    }

    public static TreeNode copy(TreeNode root) {
        return  inorderCopyRecursion(root);
    }

    private static TreeNode inorderCopyRecursion(TreeNode root) {
        if (root == null) {
            return root;
        }
//        if(root!=null){
        TreeNode treeNode = new TreeNode();
        treeNode.val = root.val;
        treeNode.left = inorderCopyRecursion(root.left);
        treeNode.right = inorderCopyRecursion(root.right);
//        }
        return treeNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", val=" + val +
                '}';
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}
