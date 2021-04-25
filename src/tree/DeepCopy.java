package tree;

import leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

public class DeepCopy {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        TreeNode copy = TreeNode.copy(treeNode);
        System.out.println(copy);

    }
}
