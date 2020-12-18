package JVM.GC;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(1000);
        if(SAVE_HOOK!=null){
            System.out.println("not null!");
        }else {
            System.out.println("null");
        }

        SAVE_HOOK = null;
        System.gc();
        if(SAVE_HOOK!=null){
            System.out.println("not null!");
        }else {
            System.out.println("null");
        }
    }
}
