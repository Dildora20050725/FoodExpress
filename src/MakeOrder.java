public class MakeOrder {
    private String name;
    private double totalPrice;

    public MakeOrder(String name, double totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void showAllOrders() {
        System.out.printf("\nName: %s\nTotal Price: %.2f\n", name, totalPrice);
    }
}
