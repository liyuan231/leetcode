package designPattern.construct;

public class CarDirector {
    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car construct() {
        carBuilder.createChassis();
        carBuilder.createTyre();
        carBuilder.createSteeringWheel();
        return carBuilder.builder();
    }
}
