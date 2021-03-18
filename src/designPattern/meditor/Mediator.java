package designPattern.meditor;

public abstract class Mediator {
    public abstract void register(Colleague colleague);

    public abstract void relay(Colleague colleague);

}
