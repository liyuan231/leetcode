package nowcoder;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class cyc_32_3 {
    public static void main(String[] args) {
        System.out.println(Print(TreeNode.create()));
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        boolean f = false;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        while (!queue.isEmpty()) {
            int l = queue.size();
            TreeNode pop;
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                pop = queue.poll();
                assert pop != null;
                tmp.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            if (f) {
                Collections.reverse(tmp);
            }
            arr.add(tmp);
            f = !f;
        }
        return arr;
    }
}
