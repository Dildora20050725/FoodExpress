import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private HashMap<String, String> users = new HashMap<>();
    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, password);
        return true;
    }
    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodManager foodManager = new FoodManager();
        Main userAuth = new Main();
        while (true) {
            System.out.println("1. Ro'yxatdan o'tish");
            System.out.println("2. Login");
            System.out.println("3. Chiqish");
            System.out.print("Tanlang: ");
            int choice1 = scanner.nextInt();
            scanner.nextLine(); // Enterni tozalash
            switch (choice1) {
                case 1:
                    System.out.print("Yangi username kiriting: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Yangi parol kiriting: ");
                    String newPassword = scanner.nextLine();

                    if (userAuth.register(newUsername, newPassword)) {
                        System.out.println("Muvaffaqiyatli ro'yxatdan o'tdingiz!");

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
                    } else {
                        System.out.println("Bu username allaqachon mavjud!");
                    }
                    break;
                case 2:
                    System.out.print("Username kiriting: ");
                    String username = scanner.nextLine();
                    System.out.print("Parol kiriting: ");
                    String password = scanner.nextLine();
                    if (userAuth.login(username, password)) {
                        System.out.println("Muvaffaqiyatli login qilindi!");
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
                    } else {
                        System.out.println("Username yoki parol noto'g'ri!");
                    }
                    break;
                case 3:
                    System.out.println("Dasturdan chiqildi.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Noto'g'ri tanlov! Qayta urinib ko'ring.");
            }
        }
    }
    private static void clientMenu(Scanner scanner, FoodManager foodManager) {
        while (true) {
            System.out.println("\nClient Menu:");
            System.out.println("1. Show All Food");
            System.out.println("2. Place an Order");
            System.out.println("3. Show Current Orders");
            System.out.println("4. Clear Current Orders");
            System.out.println("5. Show Order History");
            System.out.println("6. Back");
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
                case 3 -> foodManager.showOrders();
                case 4 -> foodManager.clearOrders();
                case 5 -> foodManager.showOrderHistory();
                case 6 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

        private static void adminMenu (Scanner scanner, FoodManager foodManager){
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Food");
            System.out.println("2. Update Food");
            System.out.println("3. Remove Food");
            System.out.println("4. Search Food by Name");
            System.out.println("5. Show All Food");
            System.out.println("6. Back");
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
                    System.out.print("Enter Food Name to Update: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();
                    foodManager.updateFood(name, newPrice, newQuantity);
                }
                case 3 -> {
                    System.out.print("Enter Food Name to Remove: ");
                    String name = scanner.nextLine();
                    foodManager.removeFoodByName(name);
                }
                case 4 -> {
                    System.out.print("Enter Food Name to Search: ");
                    String name = scanner.nextLine();
                    foodManager.searchFoodByName(name);
                }
                case 5 -> foodManager.showAllFood();
                case 6 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

}

