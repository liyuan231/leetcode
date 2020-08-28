package designPattern.construct;

public class SagitarCarBuilder implements CarBuilder{
    private Car car = new Car();
    @Override
    public void createChassis() {
        car.setChassis("设置汽车底盘！");
    }

    @Override
    public void createTyre() {
        car.setTyre("设置汽车轮胎！");
    }

    @Override
    public void createSteeringWheel() {
        car.setSteeringWheel("设置方向盘！");
    }

    @Override
    public Car builder() {
        return car;
    }

    @Override
    public String toString() {
        return "SagitarCarBuilder{" +
                "car=" + car.toString() +
                '}';
    }
}
