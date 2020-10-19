package JAVA;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class CollectionsTest {
    public static void main(String[] args) {
        Vector vector = new Vector();
        List list = Collections.synchronizedList(vector);


    }
    @Test
    public void test0(){
        test("1","2","3","4");
    }


    private void test(String... str){
        System.out.println(str instanceof String[]);
        System.out.println(str.getClass());
        for (String s : str) {
            System.out.println(s);
        }
        System.out.println(Arrays.toString(Arrays.stream(str).toArray()));
    }
}
