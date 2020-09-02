package designPattern.bridge.extend;

public class test {
    /**
     * 传统的通过继承来实现相应功能
     * @param args
     */
    public static void main(String[] args) {
        Circle circle = new GreenCircle(1,1,1);
        circle.drawCircle(1,1,1);

        Circle redCircle = new RedCircle(1,1,1);
        redCircle.drawCircle(1,1,1);
    }
}
