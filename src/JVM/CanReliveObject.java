package JVM;

public class CanReliveObject {
    public static CanReliveObject canReliveObject;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("CanReliveObject is being finalized!");
        canReliveObject = this;
    }

    public static void main(String[] args) throws InterruptedException {
        canReliveObject = new CanReliveObject();
        canReliveObject = null;
        System.out.println("first GC!");
        System.gc();
        Thread.sleep(1000);
        if (canReliveObject == null) {
            System.out.println("canReliveObject is dead!");
        } else {
            System.out.println("canReliveObject is still alive！");
        }
        canReliveObject = null;
        System.out.println("second GC!");
        System.gc();
        Thread.sleep(1000);
        if (canReliveObject == null) {
            System.out.println("canReliveObject is dead!");
        } else {
            System.out.println("canReliveObject is still alive！");
        }
    }
}
