package designPattern.factoryMethod2;

import designPattern.factoryMethod2.factory.AbstractFactory;
import designPattern.factoryMethod2.factory.ConcreteFactory1;
import designPattern.factoryMethod2.factory.ConcreteFactory2;

public class SupportProductFactory {


    public static AbstractFactory retrieveFactory(String v) {
        switch (v) {
            case "1": {
                return new ConcreteFactory1();
            }
            case "2": {
                return new ConcreteFactory2();
            }
            default:
                throw new IllegalArgumentException(v);
        }

    }
}
