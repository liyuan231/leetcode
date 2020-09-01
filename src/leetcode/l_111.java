package leetcode;

public class l_111 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(minDepth(treeNode));
    }
    public static int minDepth(TreeNode root) {
        if(root==null){return 0;}
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
