package leetcode;

import algorithm.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_210 {
    private static byte[] visited;//0:未搜索/1:搜索完成/2:搜索中
    private static List<List<Integer>> edges;
    private static Stack<Integer> stack;
    private static boolean valid = true;

    public static void main(String[] args) {
        int n = 7;
//        n=4;
        n=2;
        int[][] nums = new int[][]{
                {4, 0}, {5, 0}, {2, 0},
                {2, 1}, {0, 1},
                {5, 3},
                {6, 5}
        };
//        nums = new int[][]{
//                {1,0},{2,0},{3,1},{3,2}
//        };
        nums = new int[][]{{1,0}};
        int[] order = findOrder(n, nums);
        for (int i : order) {
            System.out.println(i);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        stack = new Stack<>();
        edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        //上述为初始化一个邻接矩阵
        visited = new byte[numCourses];
        for (int i = 0; i < edges.size(); i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        int[] result = new int[stack.size()];
        int index = 0;
        for (Integer integer : stack) {
            result[index++] = integer;
        }
        return result;
    }

    private static void dfs(int i) {
//        stack.push(i);
        visited[i] = 2;//该节点设置为正在搜索中
        List<Integer> integers = edges.get(i);
        if (integers.size() == 0) {
            //该节点无对应的可以解锁的课程,设置该课程为已完成
            stack.push(i);
            visited[i] = 1;
        }
        for (Integer integer : integers) {
            if (visited[integer] == 0) {
                dfs(integer);
            } else if (visited[integer] == 2) {
                valid = false;
                return;
            }
        }
        if (integers.size() != 0) {
            //表明该课程已经解锁了所有其他的课程
            stack.push(i);
        }
        visited[i] = 1;
    }
}
