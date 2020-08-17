package leetcode;

public class l_100 {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNode.create();
        TreeNode treeNode2 = TreeNode.create();
        System.out.println(isSameTree(treeNode1, treeNode2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
        }
        if (p == null || q == null) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

//    private boolean travel(){
//
//    }
}
