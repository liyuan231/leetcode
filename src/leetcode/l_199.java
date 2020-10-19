package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_199 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(Arrays.toString(rightSideView(treeNode).toArray()));
    }

    /**
     * 1 2 -1 5 -1 -1 3 -1 4 -1 -1
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        if(root==null){return  null;}
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        result.add(linkedList.peekLast().val);
        while (!linkedList.isEmpty()) {
            int n = linkedList.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = linkedList.poll();
                if (poll.left != null) {
                    linkedList.add(poll.left);
                }
                if (poll.right != null) {
                    linkedList.add(poll.right);
                }
            }
            TreeNode tmp = linkedList.peekLast();
            if (tmp != null) {
                result.add(tmp.val);
            }
        }
        return result;
    }

}
