package designPattern.builder;

public class Main {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        Meal meal = builder.prepareVegMeal();
        System.out.println("Veg Meal");
        meal.showItems();
        System.out.println(meal.getCost());
    }
}
