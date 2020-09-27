package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l_173 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create();
        BSTIterator iterator = new BSTIterator(root);
        List<TreeNode> list = iterator.list;
        for (TreeNode treeNode : list) {
            System.out.print(treeNode.val + "->");
        }

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }

}

class BSTIterator {
    private int curIndex;
    private int count;
    List<TreeNode> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
        this.count = list.size();
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!hasNext()) {
            throw new NullPointerException();
        }
        return list.get(curIndex++).val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return curIndex != count;
    }
}
