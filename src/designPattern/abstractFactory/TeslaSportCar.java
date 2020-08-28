package designPattern.abstractFactory;

public class TeslaSportCar implements TeslaCar{
    @Override
    public void gasUp() {
        System.out.println("TeslaSportCar is being gaed up!");
    }

    @Override
    public void charge() {
        System.out.println("TeslaSportCar is being charged!");
    }
}
