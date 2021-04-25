package cyc;

import leetcode.TreeNode;

public class l_111 {
    public static void main(String[] args) {
        System.out.println(minDepth(TreeNode.create(new Integer[]{2,null,3,null,4,null,5,null,6})));
    }

    private static int min = Integer.MAX_VALUE;

    //    private static int min = ;
    public static int minDepth(TreeNode root) {
        minDepth(root, 1);
        return min;
    }

    private static void minDepth(TreeNode root, int curDepth) {
        if(root==null){return;}
        if (root.left == null&&root.right==null) {
            min = Math.min(curDepth, min);
            return;
        }
        minDepth(root.left, curDepth + 1);
        minDepth(root.right, curDepth + 1);
    }
}
