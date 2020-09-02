package designPattern.bridge;

public class test {
    /**
     * 通过桥接模式实现相应功能！！
     *
     * @param args
     */
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 1, 1, 1);
        redCircle.draw();

        Shape greenCircle = new Circle(new GreenCircle(), 1, 1, 1);
        greenCircle.draw();
    }
}
