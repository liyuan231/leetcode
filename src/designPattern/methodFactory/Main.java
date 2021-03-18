package designPattern.methodFactory;

import designPattern.methodFactory.factory.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory p1 = FactoryPro.getFactory("p2");
        Product product = p1.newProduct();
        product.show();
    }
}
