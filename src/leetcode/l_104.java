package leetcode;

public class l_104 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(maxDepth(treeNode));
    }
    public static int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }

    private static int maxDepth(TreeNode root, int maxDepth) {
        if(root==null){return maxDepth;}
        return Math.max(Math.max(maxDepth(root.left,maxDepth+1),maxDepth(root.right,maxDepth+1)),maxDepth);
    }
}
