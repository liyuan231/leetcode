package algorithm.sort;

import org.junit.Test;

import java.util.Comparator;
import java.util.Date;

public class Transaction{
    private  String who;
    private  Date when;
    private  double amount;

    public Transaction() {
    }

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public static class WhoOrder implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.who.compareTo(o2.who);
        }
    }

    public static class WhenOrder implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.when.compareTo(o2.when);
        }
    }

    public static class HowMuchOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction o1, Transaction o2) {
            return (int) (o1.amount - o2.amount);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "who='" + who + '\'' +
                ", when=" + when +
                ", amount=" + amount +
                '}';
    }




    public static void main(String[] args) {
        Transaction[] transactions = new Transaction[100];
        for (int i = 0; i < transactions.length; i++) {
            String s = "name-" + (char) ((int) (Math.random() * 255));
            transactions[i] = new Transaction(s, new Date((long) (Math.random() * System.currentTimeMillis())), Math.random() * 999);
        }
        Insertion.sort(transactions,new Transaction.HowMuchOrder());

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
