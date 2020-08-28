package designPattern.abstractFactory;

public class BenzBusinessCar implements BenzCar {
    @Override
    public void gasUp() {
        System.out.println("BenzBusinessCar is being gased up!");
    }

    @Override
    public void charge() {
        System.out.println("BenzBusinessCar is being charged!");
    }
}
