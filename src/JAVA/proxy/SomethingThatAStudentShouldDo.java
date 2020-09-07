package JAVA.proxy;

public interface SomethingThatAStudentShouldDo {
    public void study();

    public void play();

    default public void drink() {
        System.out.println("Drinking!!!");
    }
}
