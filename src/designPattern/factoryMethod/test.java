package designPattern.factoryMethod;

import designPattern.factoryMethod.factory.ProductFactory;
import designPattern.factoryMethod.factory.impl.ProductAFactory;
import designPattern.factoryMethod.factory.impl.ProductBFactory;

public class test {
    public static void main(String[] args) {
        ProductFactory productAFactory = new ProductAFactory();
        System.out.println(productAFactory.getProduct());

        ProductFactory productBFactory = new ProductBFactory();
        System.out.println(productBFactory.getProduct());
        //当我需要增加一个ProductC时，我需要做的是再写一个ProductCFactory类以及ProductC类即可，符合开闭原则
    }
}
