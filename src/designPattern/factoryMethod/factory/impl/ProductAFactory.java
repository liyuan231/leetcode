package designPattern.factoryMethod.factory.impl;

import designPattern.factoryMethod.factory.ProductFactory;
import designPattern.factoryMethod.product.Product;
import designPattern.factoryMethod.product.ProductA;

public class ProductAFactory implements ProductFactory {
    @Override
    public Product getProduct() {
        return new ProductA();
    }
}
