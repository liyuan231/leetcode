package JAVA;

public interface AInterafce {
    public void play();
    default public void test(){
        System.out.println("test");
    }

}
