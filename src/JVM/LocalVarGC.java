package JVM;

public class LocalVarGC {
    public void lcoalvarGC1() {
        byte[] _10M = new byte[10 * 1024 * 1024];
        System.gc();
    }

    public void localvarGC2() {
        byte[] _10M = new byte[10 * 1024 * 1024];
        _10M = null;
        System.gc();
    }

    public void localvarGC3() {
        {
            byte[] _10M = new byte[10 * 1024 * 1024];
        }
        System.gc();
    }

    public void lcoalvar4() {
        {
            byte[] _10M = new byte[10 * 1024 * 1024];
        }
        int value = 10;
        System.gc();
    }
    public void localvar5(){
        lcoalvarGC1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGC localVarGC = new LocalVarGC();
        localVarGC.lcoalvarGC1();
    }
}
