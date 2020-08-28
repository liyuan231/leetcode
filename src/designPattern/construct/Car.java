package designPattern.construct;

public class Car {
    private String chassis;
    private String tyre;
    private String steeringWheel;

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "chassis='" + chassis + '\'' +
                ", tyre='" + tyre + '\'' +
                ", steeringWheel='" + steeringWheel + '\'' +
                '}';
    }
}
