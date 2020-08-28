package designPattern.construct;

public interface CarBuilder {
    public void createChassis();
    public void createTyre();
    public void createSteeringWheel();
    public Car builder();
}
