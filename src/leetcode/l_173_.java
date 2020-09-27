package leetcode;


import java.util.Stack;

public class l_173_ {
    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(TreeNode.create());

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

    static class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            if (!hasNext()) {
                throw new NullPointerException();
            }
            TreeNode topNode = stack.pop();

            TreeNode right = topNode.right;

            while (right != null) {
                stack.push(right);
                right = right.left;
            }

            return topNode.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
