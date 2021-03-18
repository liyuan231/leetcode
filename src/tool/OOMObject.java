package tool;

import java.util.ArrayList;
import java.util.List;

public class OOMObject {
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> oomObjectList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(500);
            oomObjectList.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}