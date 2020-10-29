package leetcode;

import org.junit.Test;

import java.util.*;

public class l_207 {
    public static void main(String[] args) {
        int i = 7;
        int[][] nums = new int[][]{{2, 0}, {5, 0}, {4, 0},
                {0, 1}, {2, 1}, {5, 3}, {4, 5}, {6, 5}};

//        i = 3;
//        nums = new int[][]{{1, 0}, {2, 1},{0,2}};
        System.out.println(canFinish(i, nums));

    }

    private static List<List<Integer>> edges;
    private static byte[] visited;//0:为搜索;1:搜索完成；2：搜索中
    private static Stack<Integer> stack;


    private static boolean ans = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        stack = new Stack<>();
        visited = new byte[numCourses];
        //初始化
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < edges.size(); i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        System.out.println(Arrays.toString(edges.toArray()));
        System.out.print("[");
        for (byte b : visited) {
            System.out.print(b + ",");
        }
        System.out.print("]\n");
        return ans;
    }

    private static void dfs(int i) {
        visited[i] = 2;//设置该节点正在搜索中
        List<Integer> integers = edges.get(i);
        if (integers.size() == 0) {
            System.out.print(i + "->");
            visited[i] = 1;//该节点搜索完成
            return;
        }
        for (Integer integer : integers) {
            if (visited[integer] == 0) {
                dfs(integer);
            } else if (visited[integer] == 2) {
                ans = false;
                return;
            }
        }
        visited[i] = 1;//该节点搜索完成
        System.out.print(i + "->");
    }

    @Test
    public void test0() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Integer v = (int) (Math.random() * (200 - 100) + 200);
            set.add(v);
        }
        System.out.println(set);

    }
}
