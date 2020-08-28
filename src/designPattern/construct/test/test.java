package designPattern.construct.test;

import designPattern.construct.Car;
import designPattern.construct.CarDirector;
import designPattern.construct.SagitarCarBuilder;

public class test {
    public static void main(String[] args) {
        CarDirector carDirector = new CarDirector(new SagitarCarBuilder());
        Car car = carDirector.construct();
        System.out.println(car.toString());
        //若我要扩展一个新的产品奔驰，仅需构建一个BenzCarBuilder并书写具体逻辑即可
        CarDirector carDirector1 = new CarDirector(new BenzCarBuilder());
        Car car1 = carDirector1.construct();
        System.out.println(car1.toString());

    }
}
