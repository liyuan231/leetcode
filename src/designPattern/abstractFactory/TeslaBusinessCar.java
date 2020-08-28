package designPattern.abstractFactory;

public class TeslaBusinessCar implements TeslaCar{
    @Override
    public void gasUp() {
        System.out.println("TeslaBusinessCar is being gased up!");
    }

    @Override
    public void charge() {
        System.out.println("TeslaBusinessCar is being charged!");
    }
}
