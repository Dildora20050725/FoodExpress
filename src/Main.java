import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodManager foodManager = new FoodManager();
        boolean exit = false;
        while (!exit){
            System.out.println("===FoodExpress===");
            System.out.println("Choice command: ");
            System.out.println("1.Admin");
            System.out.println("2.Client");
            int command = scanner.nextInt();
            scanner.nextLine();
            if (command==1){
                boolean back = false;
                while (!back){
                    System.out.println("\nChoice command: ");
                    System.out.println("1-Add food");
                    System.out.println("2-Update food");
                    System.out.println("3-Remove food");
                    System.out.println("4-Search food");
                    System.out.println("5-Show all food");
                    System.out.println("6-Back");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice){
                        case 1:
                            System.out.println("Enter id: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter country: ");
                            String country = scanner.nextLine();
                            System.out.println("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.println("Enter price: ");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Enter quantity");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            Food food = new Food(id, country, name, price, quantity);
                            foodManager.addFood(food);
                            System.out.println("Added successfully!");
                            break;
                        case 2:
                            System.out.println("Enter nme: ");
                            String nameUpdate = scanner.nextLine();
                            System.out.println("Update price: ");
                            double priceUpdate = scanner.nextDouble();
                            for (int i = 0; i < foodManager.foods.size(); i++) {
                                if (foodManager.foods.get(i).getNameOfFood().equals(nameUpdate)){
                                    foodManager.foods.get(i).priceOfFood = priceUpdate;
                                }
                            }
                            System.out.println("Updated successfully!");
                            break;
                        case 3:
                            System.out.println("Enter food name: ");
                            String removeFoodName = scanner.nextLine();
                            foodManager.removeFoodByName(removeFoodName);
                            System.out.println("Removed successfully!");
                            break;
                        case 4:
                            System.out.println("Enter name: ");
                            String searchName = scanner.nextLine();
                            foodManager.searchFoodByName(searchName);
                            break;
                        case 5:
                            foodManager.showAllFood();
                            break;
                        case 6:
                            back = true;
                            break;
                        default:
                            System.out.println("Command is wrong!");




                    }

                }
            }
            else if (command==2){
                boolean back = false;
                while (!back){
                    System.out.println("FoodExpress Menu");
                    System.out.println("1.Show all food");
                    System.out.println("2.Search food");
                    System.out.println("3.Order list");
                    System.out.println("4.History of food");
                    System.out.println("5.Back");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice){
                        case 1:
                            System.out.println("Order food: ");
                            foodManager.showAllFood();
                            System.out.println("Choose food: ");
                            int choose = scanner.nextInt();
                            System.out.println("Enter quantity: ");
                            int quantity = scanner.nextInt();
                            for (int i = 0; i < foodManager.foods.size(); i++) {
                                if (choose == foodManager.foods.get(i).id){
                                    double totalAmount = foodManager.foods.get(i).priceOfFood*quantity;
                                    MakeOrder makeOrder = new MakeOrder(foodManager.foods.get(i).nameOfFood, totalAmount);
                                    foodManager.orders.add(makeOrder);
                                    System.out.println("Accepted");
                                    break;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter food name: ");
                            String searchName = scanner.nextLine();
                            foodManager.searchFoodByName(searchName);
                            break;
                        case 3:
                            foodManager.orderList();
                            break;
                        case 4:
                            foodManager.showAllHistory();
                            break;
                        case 5:
                            back = true;
                            break;
                        default:
                            System.out.println("Choose wrong command!");
                    }
                }
            }
        }
    }
}