package threads;

public class Account {
    private String name;
    private double balance;

    public synchronized void set(String name,double balance){
        this.name = name;
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.set("liyuan",100d);
            }
        }).start();
    }
}
