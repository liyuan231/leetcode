package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 依照后序遍历以及中序遍历构树
 */
public class l_106 {
    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        TreeNode.inorderTraversal(treeNode);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int inLen = inorder.length;
        int postLen = postorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inLen - 1, map, postorder, 0, postLen - 1);
    }

    private static TreeNode buildTree(int[] inorder,
                                      int inLeft,
                                      int inRight,
                                      Map<Integer, Integer> map,
                                      int[] postorder,
                                      int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        int pIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inLeft, pIndex - 1, map, postorder, postLeft, pIndex + postLeft - inLeft - 1);
        root.right = buildTree(inorder, pIndex + 1, inRight, map, postorder, pIndex + postLeft - inLeft, postRight - 1);
        return root;
    }
}
