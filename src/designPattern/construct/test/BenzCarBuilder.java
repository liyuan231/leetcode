package designPattern.construct.test;

import designPattern.construct.Car;
import designPattern.construct.CarBuilder;

public class BenzCarBuilder implements CarBuilder {
    private Car car = new Car();

    @Override
    public void createChassis() {
        car.setChassis("奔驰的底盘！");
    }

    @Override
    public void createTyre() {
        car.setTyre("奔驰的轮胎！");
    }

    @Override
    public void createSteeringWheel() {
        car.setSteeringWheel("奔驰的方向盘！");
    }

    @Override
    public Car builder() {
        return car;
    }
}
