package designPattern.factoryMethod.factory.impl;

import designPattern.factoryMethod.factory.ProductFactory;
import designPattern.factoryMethod.product.Product;
import designPattern.factoryMethod.product.ProductB;

public class ProductBFactory implements ProductFactory {
    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
