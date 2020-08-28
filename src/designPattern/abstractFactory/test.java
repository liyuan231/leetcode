package designPattern.abstractFactory;

import designPattern.abstractFactory.factory.CarFactory;
import designPattern.abstractFactory.factory.impl.BusinessCarFactory;
import designPattern.abstractFactory.factory.impl.SportCarFactory;

public class test {
    public static void main(String[] args) {
        CarFactory businessCarFactory = new BusinessCarFactory();
        BenzCar benzCar = businessCarFactory.getBenzCar();
        TeslaCar teslaCar = businessCarFactory.getTeslaCar();


        CarFactory sportCarFactory = new SportCarFactory();
        BenzCar benzCar1 = sportCarFactory.getBenzCar();
        TeslaCar teslaCar1 = sportCarFactory.getTeslaCar();

        /*当我需要扩展一种比如BenzNewCar时,仅需实现BenzCar类，并写一个NewCarFactory即可并
         @Override
        public BenzCar getBenzCar() {
            return new BenzNewCar();
        }
         */
        CarFactory newCarFactory = new NewCarFactory();
        BenzCar benzNewCar = newCarFactory.getBenzCar();


    }
}
