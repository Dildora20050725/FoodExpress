import java.util.ArrayList;

public class FoodManager {
    ArrayList<Food> foods = new ArrayList<>();
    ArrayList<MakeOrder> orders = new ArrayList<>();


    public void addFood(Food food){
        foods.add(food);
    }
    public void makeOrder(MakeOrder makeOrder){
        orders.add(makeOrder);
    }
    public void removeFoodByName(String name){
        if (foods.isEmpty()){
            System.out.println("Not found food!");
        }else {
            for (Food food:foods){
                if (food.getNameOfFood().equals(name)){
                    foods.remove(food);
                }
            }
        }
    }
    public void searchFoodByName(String name){
        boolean found = false;
        if (foods.isEmpty()){
            System.out.println("Not found food!");
        }else {
            for (Food food: foods){
                if (food.getNameOfFood().equals(name)){
                    food.showFoodData();
                    found = true;
                    break;
                }
            }
        }
        if (!found){
            System.out.println("Food with this name: "+name+"was not found!");
        }

    }
    public void showAllFood(){
        if (foods.isEmpty()){
            System.out.println("Not found food!");
        }else {
            for (Food food: foods){
                food.showFoodData();
            }
            System.out.println("\n-----------------------------------------");
        }

    }
    public void orderList(){
        double totalAmount = 0;
        if (orders.isEmpty()){
            System.out.println("This order is not available!");
        }else {
            System.out.println("Order list: ");

            System.out.println("TotalAmount: "+totalAmount);
        }
    }
    public void showAllHistory(){
        for (MakeOrder makeOrder: orders){
            makeOrder.showAllOrders();
        }
    }
}

