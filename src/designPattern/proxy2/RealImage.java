package designPattern.proxy2;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        laodFromDisk(fileName);
    }

    private void laodFromDisk(String fileName) {
        System.out.println("loading...");
    }

    @Override
    public void display() {
        System.out.println("Displaying real image: " + fileName);
    }
}
