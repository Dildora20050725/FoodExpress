import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodManager foodManager = new FoodManager();
        ArrayList<Register> registers = new ArrayList<>();
        System.out.println("---Welcome to FoodExpress---");
        System.out.println("1.Registration");
        System.out.println("2.Login");
        int choose = scanner.nextInt();
        boolean back = false;
        switch (choose) {
            case 1:
                System.out.println("Enter first name: ");
                String firstName = scanner.next();
                String f1 = "";
                for (int i = 0; i < firstName.length(); i++) {
                    char ch = firstName.charAt(i);
                    if (Character.isLetter(ch)){
                        f1 = firstName;
                    }
                }
                System.out.println("Enter last name: ");
                String lastName = scanner.next();
                String l1 = "";
                for (int i = 0; i < firstName.length(); i++) {
                    char ch = firstName.charAt(i);
                    if (Character.isLetter(ch)){
                        l1 = firstName;
                    }
                }
                System.out.println("Enter phone number: ");
                String phoneNumber = scanner.next();
                String p1 = "";
                if (phoneNumber.length() == 12) {
                    phoneNumber.startsWith("998" , 3);
                    p1 = phoneNumber;
                }
                Register register = new Register(firstName, lastName, phoneNumber);
                registers.add(register);
                System.out.println("Registration completed.");
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
            case 2:
                System.out.println("Enter first name: ");
                String firstname = scanner.nextLine();
                System.out.println("Enter last name: ");
                String lastname = scanner.nextLine();
                Register register1 = new Register();
                if (firstname.equals(register1.getFirstName()) && lastname.equals(register1.getLastName())) {
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
                                System.out.println("Returning to Main Menu...");
                                return;
                            }
                            default -> System.out.println("Invalid choice!");
                        }
                    }
                }else {
                    System.out.println("Invalid choice!");
                }
                break;

        }
    }

    private static void adminMenu(Scanner scanner, FoodManager foodManager) {
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
}
