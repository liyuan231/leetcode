package designPattern.abstractFactory;

public class BenzSportCar implements BenzCar{
    @Override
    public void gasUp() {
        System.out.println("BenzSportCar is being gased up!");
    }

    @Override
    public void charge() {
        System.out.println("BenzSportCar is being charged!");
    }
}
