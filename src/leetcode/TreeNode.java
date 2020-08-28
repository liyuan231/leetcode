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

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", val=" + val +
                '}';
    }
    public static void inorderTraversal(TreeNode root) {
        if(root==null){return;}
        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        inorderTraversal(root.right);
    }
}
