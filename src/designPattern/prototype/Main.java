package designPattern.prototype;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("1");
        System.out.println(shape);
    }
}
