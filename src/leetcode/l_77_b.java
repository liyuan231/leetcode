package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class l_77_b {
    public static void main(String[] args) {

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        backtrack(result,stack,n,k,1);
        return result;
    }

    private void backtrack(List<List<Integer>> result,Stack<Integer> stack, int n, int k, int begin) {
        if(stack.size()==k){

            result.add(new LinkedList<>(stack));
            return;
        }
        for(int i =begin;i<=n;i++){
            stack.push(i);
            backtrack(result,stack,n,k,i+1);
            stack.pop();
        }
    }
}
