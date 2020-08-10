package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_77 {
    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        List<List<Integer>> combine = combine(n, k);
        for (List<Integer> integers : combine) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0 || n == 0) {
            return result;
        }
        List<Integer> curList = new ArrayList<>();
        backtrack(result,curList,n,k,1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> curList,int range, int limit,int curIndex) {
        if(curList.size()>=2&&curList.get(curList.size()-1)<curList.get(curList.size()-2)){
            return;
        }
        if(curList.size()==limit){
           result.add(new ArrayList<>(curList));
            return;
        }
        for(int i=curIndex;i<=range;i++){
            if(!curList.contains(i)){
                curList.add(i);
                backtrack(result,curList,range,limit,curIndex++);
                curList.remove(curList.size()-1);
            }
        }
    }

}
