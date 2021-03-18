package designPattern.meditor;

public abstract class Colleague {
    Mediator mediator;

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();

}
