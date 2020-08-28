package designPattern.abstractFactory.factory.impl;

import designPattern.abstractFactory.BenzCar;
import designPattern.abstractFactory.BenzSportCar;
import designPattern.abstractFactory.TeslaCar;
import designPattern.abstractFactory.TeslaSportCar;
import designPattern.abstractFactory.factory.CarFactory;

public class SportCarFactory implements CarFactory {
    @Override
    public BenzCar getBenzCar() {
        return new BenzSportCar();
    }

    @Override
    public TeslaCar getTeslaCar() {
        return new TeslaSportCar();
    }
}
