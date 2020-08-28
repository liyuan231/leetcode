package designPattern.abstractFactory;

import designPattern.abstractFactory.factory.CarFactory;

public class NewCarFactory implements CarFactory {
    @Override
    public BenzCar getBenzCar() {
        return new BenzNewCar();
    }

    @Override
    public TeslaCar getTeslaCar() {
        return null;
    }
}
