package designPattern.abstractFactory.factory.impl;

import designPattern.abstractFactory.BenzBusinessCar;
import designPattern.abstractFactory.BenzCar;
import designPattern.abstractFactory.TeslaBusinessCar;
import designPattern.abstractFactory.TeslaCar;
import designPattern.abstractFactory.factory.CarFactory;

public class BusinessCarFactory implements CarFactory {
    @Override
    public BenzCar getBenzCar() {
        return new BenzBusinessCar();
    }

    @Override
    public TeslaCar getTeslaCar() {
        return new TeslaBusinessCar();
    }
}
