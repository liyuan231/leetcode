package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bt {
    public static void main(String[] args) {
        backtrack(new ArrayList<>(),4,4);
    }

    private static void backtrack(List<Integer> list, int i,int n) {
        if(list.size()==n){
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }
        for (int j = 0; j < i; j++) {
            list.add(j);
            backtrack(list,j+1,n);
            list.remove(list.size()-1);
        }
    }
}
