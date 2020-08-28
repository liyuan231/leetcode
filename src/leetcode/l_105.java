package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 依照先序遍历以及中序遍历构造树
 */
public class l_105 {
    public static void main(String[] args) {
        int[]preorder = new int[]{3,9,20,15,7};
        int[]inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        TreeNode.inorderTraversal(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen-1, map, 0, inLen-1);
    }

    private static TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);
        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }
}
