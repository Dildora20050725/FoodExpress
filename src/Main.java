import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodManager foodManager = new FoodManager();

        while (true) {
            System.out.println("\n=== FoodExpress ===");
            System.out.println("1. Admin");
            System.out.println("2. Client");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> adminMenu(scanner, foodManager);
                case 2 -> clientMenu(scanner, foodManager);
                case 3 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void adminMenu(Scanner scanner, FoodManager foodManager) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Show All Food");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Food Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Country: ");
                    String country = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    foodManager.addFood(new Food(foodManager.foods.size() + 1, country, name, price, quantity));
                    System.out.println("Food added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Food Name to Remove: ");
                    String name = scanner.nextLine();
                    foodManager.removeFoodByName(name);
                }
                case 3 -> foodManager.showAllFood();
                case 4 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void clientMenu(Scanner scanner, FoodManager foodManager) {
        while (true) {
            System.out.println("\nClient Menu:");
            System.out.println("1. Show All Food");
            System.out.println("2. Place an Order");
            System.out.println("3. Show Orders");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> foodManager.showAllFood();
                case 2 -> {
                    System.out.print("Enter Food Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    for (Food food : foodManager.foods) {
                        if (food.getNameOfFood().equalsIgnoreCase(name)) {
                            double total = food.getPriceOfFood() * quantity;
                            foodManager.makeOrder(new MakeOrder(name, total));
                            System.out.println("Order placed successfully!");
                            break;
                        }
                    }
                }
                case 3 -> foodManager.showAllOrders();
                case 4 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
