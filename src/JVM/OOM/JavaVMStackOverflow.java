package JVM.OOM;

public class JavaVMStackOverflow {
    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackOverflow javaVMStackOverflow = new JavaVMStackOverflow();
        try {
            javaVMStackOverflow.stackLeak();
        } catch (StackOverflowError e) {
            System.out.println("Stack Depth:" + javaVMStackOverflow.stackLength);
            throw e;
        }
    }
}
