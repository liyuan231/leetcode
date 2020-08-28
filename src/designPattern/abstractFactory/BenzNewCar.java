package designPattern.abstractFactory;

public class BenzNewCar implements BenzCar {
    @Override
    public void gasUp() {
        System.out.println("BenzNewCar is being gased up!");
    }

    @Override
    public void charge() {
        System.out.println("BenzNewCar is being charged!");
    }
}
