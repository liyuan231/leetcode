package dp;

import leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

public class l_318 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(sum(treeNode,10));
    }

    private static boolean sum(TreeNode treeNode, int sum) {
        return solve(treeNode,sum,0);
    }

    private static boolean solve(TreeNode node, int sum, int curSum) {
//        System.out.println(curSum+node.val);
        if(node.left==null&&node.right==null){
            return node.val+curSum==sum;
        }

        if(node.left==null){
            return solve(node.right,sum,curSum+node.val);
        }
        if(node.right==null){
            return solve(node.left,sum,curSum+node.val);
        }
//        if(node.left!=null){
//           return  solve(node.left,sum,curSum+node.val);
//        }
//        if(node.right!=null){
//            return solve(node.right,sum,curSum+node.val);
//        }
        return solve(node.left,sum,curSum+node.val)||solve(node.right,sum,curSum+node.val);

    }

    public int[] countBits(int num) {
        return null;
    }
    //23443ab49abe
    //23
    //234
}
