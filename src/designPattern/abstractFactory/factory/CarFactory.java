package designPattern.abstractFactory.factory;

import designPattern.abstractFactory.BenzCar;
import designPattern.abstractFactory.TeslaCar;

public interface CarFactory {
    public BenzCar getBenzCar();
    public TeslaCar getTeslaCar();
}
