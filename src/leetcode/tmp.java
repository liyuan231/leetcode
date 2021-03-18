package leetcode;

public class tmp {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(maxDepth(treeNode,0));
    }

    private static int maxDepth(TreeNode node,int depth){
        if(node==null){return depth;}
        return Math.max(maxDepth(node.left,depth+1),maxDepth(node.right,depth+1));
    }
}
