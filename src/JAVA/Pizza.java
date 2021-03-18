package JAVA;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza implements Serializable {
//    @Serial
    private static final long serialVersionUID = -1433585629877076833L;
    private PizzaStatus pizzaStatus;
    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses = EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);


//    public Pizza() {
//        this.pizzaStatus = PizzaStatus.ORDERED;
//    }


//    public Pizza(PizzaStatus pizzaStatus) {
//        this.pizzaStatus = pizzaStatus;
//    }

    public enum PizzaStatus {
        /*
        pizza处于下单状态；
         */
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        /*
        pizza处于做好了的状态
         */
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        /*
        pizza处于正在被配送的状态
         */
        DELIVERE(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        public void setTimeToDelivery(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

    }

    public boolean isDeliverable() {
        return getPizzaStatus() == PizzaStatus.READY;
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " + this.getPizzaStatus().getTimeToDelivery());
    }

    public PizzaStatus getPizzaStatus() {
        return pizzaStatus;
    }

    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
//        return input.stream().filter(Pizza::isDeliverable).collect(Collectors.toList());
        return input.stream().filter((s) -> undeliveredPizzaStatuses.contains(s.getPizzaStatus())).collect(Collectors.toList());
    }

    public void deliver() {
        if (isDeliverable()) {
//            Pizza
        }
    }

    public static void main(String[] args) {
//        Pizza pizza = new Pizza();
//        pizza.setPizzaStatus(PizzaStatus.READY);
//        System.out.println(pizza.isDeliverable());
//        assert pizza.isDeliverable();
//        List<Pizza> pizzas = new ArrayList<>();
//        pizzas.add(new Pizza(PizzaStatus.READY));
//        pizzas.add(new Pizza(PizzaStatus.ORDERED));
//        pizzas.add(new Pizza(PizzaStatus.DELIVERE));
//        List<Pizza> allUndeliveredPizzas = getAllUndeliveredPizzas(pizzas);
//        System.out.println(allUndeliveredPizzas);

        List<Pizza> pzList = new ArrayList<>();
        Pizza p1 = new Pizza();
        p1.setPizzaStatus(PizzaStatus.DELIVERE);
        Pizza p2 = new Pizza();
        p1.setPizzaStatus(PizzaStatus.ORDERED);
        Pizza p3 = new Pizza();
        p1.setPizzaStatus(PizzaStatus.READY);
        pzList.add(p1);
        pzList.add(p2);
        pzList.add(p3);
        List<Pizza> allUndeliveredPizzas = Pizza.getAllUndeliveredPizzas(pzList);
        System.out.println(Arrays.toString(allUndeliveredPizzas.toArray()));


    }

    @Test
    public void givenPizzaOrders_whenGroupByStatusCalled_ThenCorrectlyGrouped() {
        System.out.println(1);

    }

    @Test
    public void testSerialize() throws IOException, ClassNotFoundException {
        ObjectInstance o = new ObjectInstance();
        Object instance = o.getInstance();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./p.ser"))) {
            objectOutputStream.writeObject(instance);
        }

        ObjectInstance o2;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./p.ser"))) {
            o2 = (ObjectInstance) objectInputStream.readObject();
        }
        System.out.println(instance);
        System.out.println(o2);

    }

}
