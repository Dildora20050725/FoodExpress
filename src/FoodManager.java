import java.util.ArrayList;

public class FoodManager {
    ArrayList<Food> foods = new ArrayList<>();
    ArrayList<MakeOrder> orders = new ArrayList<>();

    // Add food
    public void addFood(Food food) {
        foods.add(food);
    }

    // Place an order
    public void makeOrder(MakeOrder makeOrder) {
        orders.add(makeOrder);
    }

    // Remove food by name
    public void removeFoodByName(String name) {
        boolean removed = false;
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getNameOfFood().equalsIgnoreCase(name)) {
                foods.remove(i);
                removed = true;
                System.out.println(name + " removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Food not found!");
        }
    }

    // Search food by name
    public void searchFoodByName(String name) {
        boolean found = false;
        for (Food food : foods) {
            if (food.getNameOfFood().equalsIgnoreCase(name)) {
                food.showFoodData();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Food not found!");
        }
    }

    // Show all food items
    public void showAllFood() {
        if (foods.isEmpty()) {
            System.out.println("No food available.");
        } else {
            for (Food food : foods) {
                food.showFoodData();
            }
        }
    }

    // Show all orders
    public void showAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders have been placed yet.");
        } else {
            for (MakeOrder order : orders) {
                order.showAllOrders();
            }
        }
    }
}
