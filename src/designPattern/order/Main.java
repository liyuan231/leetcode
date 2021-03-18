package designPattern.order;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.taskOrder(buyStock);
        broker.taskOrder(sellStock);
        broker.placeOrders();
    }
}
