package designPattern.methodFactory;

import designPattern.methodFactory.factory.AbstractFactory;
import designPattern.methodFactory.factory.Factory1;
import designPattern.methodFactory.factory.Factory2;

public class FactoryPro {
    public static AbstractFactory getFactory(String product) {
        switch (product) {
            case "p1": {
                return new Factory1();
            }
            case "p2": {
                return new Factory2();
            }
            default:
                throw new IllegalArgumentException(product);
        }
    }
}
