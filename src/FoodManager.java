import java.util.ArrayList;

public class FoodManager {
    ArrayList<Food> foods = new ArrayList<>();
    ArrayList<MakeOrder> orders = new ArrayList<>();
    ArrayList<MakeOrder> orderHistory = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    public void updateFood(String name, double newPrice, int newQuantity) {
        boolean updated = false;
        for (Food food : foods) {
            if (food.getNameOfFood().equalsIgnoreCase(name)) {
                food.setPriceOfFood(newPrice);
                food.setQuantity(newQuantity);
                updated = true;
                System.out.println("Food updated successfully!");
                break;
            }
        }
        if (!updated) {
            System.out.println("Food with name '" + name + "' not found!");
        }
    }

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
            System.out.println("Food with name '" + name + "' not found!");
        }
    }

    public void showAllFood() {
        if (foods.isEmpty()) {
            System.out.println("No food available.");
        } else {
            System.out.println("\n=== Available Food ===");
            for (Food food : foods) {
                food.showFoodData();
            }
        }
    }

    public void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("No current orders.");
        } else {
            System.out.println("\n=== Current Orders ===");
            for (MakeOrder order : orders) {
                order.showAllOrders();
            }
        }
    }

    public void showOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No order history available.");
        } else {
            System.out.println("\n=== Order History ===");
            for (MakeOrder order : orderHistory) {
                order.showAllOrders();
            }
        }
    }

    public void clearOrders() {
        if (orders.isEmpty()) {
            System.out.println("No current orders to clear.");
        } else {
            orders.clear();
            System.out.println("All current orders have been cleared.");
        }
    }
    public void makeOrder(MakeOrder makeOrder) {
        orders.add(makeOrder);
        orderHistory.add(makeOrder);
    }
}
