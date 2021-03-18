package designPattern.enjoy;

public class Main {
    private static final String[] colors = new String[]{"red", "green", "blue", "white", "black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getShape(getRandomColor());
            circle.setX((int)(Math.random()*100));
            circle.setY((int)(Math.random()*100));
            circle.setRadius((int) (Math.random() * 100));
            circle.draw();
        }
    }



    private static String getRandomColor() {
        int i = (int) (Math.random() * colors.length);
        return colors[i];
    }
}
