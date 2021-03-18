package designPattern.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 这不就是包装类模式！！！
 */
public class Main {
    public static void main(String[] args) {
        Shape c = new Circle();
        RedShapedecorator redShapedecorator = new RedShapedecorator(new Circle());
        ArrayList<Object> list = new ArrayList<>();

        List<Object> objects = Collections.synchronizedList(list);

    }
}
