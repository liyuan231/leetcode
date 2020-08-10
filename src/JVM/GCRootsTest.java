package JVM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GCRootsTest {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        Date birth = new Date();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
            Thread.sleep(100);
        }
        System.out.println("first finished!");

        new Scanner(System.in).next();
        list = null;
        birth = null;
        System.out.println("list and birth are null now!");
        new Scanner(System.in).next();
        System.out.println("Finally over!");
    }
}
