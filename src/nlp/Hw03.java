package nlp;

import leetcode.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Hw03 {

    static {
        System.out.println("static");
    }

    public Hw03() {
        System.out.println("constructor");
    }

    public static void main(String[] args) throws InterruptedException {
//        Hw03 hw03 = new Hw03();

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                System.out.println(finalI);
            });
            thread.start();
            thread.join();
        }
        List<String> strings = Arrays.asList("1", "2", "3");
        strings.set(0, "liyuan");
        strings.remove(0);
//        strings.add("yuanxi");
        System.out.println(Arrays.toString(strings.toArray()));
//        Collectors.toList()
//        strings.stream().distinct()
//        Collections.synchronized

    }

    @Test
    public void test01() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, null, null, null, null, null, null, null, null};
//        TreeNode.create(array);
        TreeNode treeNode = create(array, 0);
        System.out.println(1);
    }

    private TreeNode create(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = create(nums, 2 * index + 1);
        root.right = create(nums, 2 * index + 2);
        return root;
    }

}
