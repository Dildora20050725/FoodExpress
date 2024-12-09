public class MakeOrder {
    String name;
    double quantity;
    public MakeOrder(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void showAllOrders(){
        System.out.printf("\nName: %s\nQuantity: %s", name, quantity);
    }
}
