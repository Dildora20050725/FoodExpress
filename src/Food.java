public class Food {
    private int id;
    private String countryOfFood;
    private String nameOfFood;
    private double priceOfFood;
    private int quantity;

    public Food(int id, String countryOfFood, String nameOfFood, double priceOfFood, int quantity) {
        this.id = id;
        this.countryOfFood = countryOfFood;
        this.nameOfFood = nameOfFood;
        this.priceOfFood = priceOfFood;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryOfFood() {
        return countryOfFood;
    }

    public void setCountryOfFood(String countryOfFood) {
        this.countryOfFood = countryOfFood;
    }

    public String getNameOfFood() {
        return nameOfFood;
    }

    public void setNameOfFood(String nameOfFood) {
        this.nameOfFood = nameOfFood;
    }

    public double getPriceOfFood() {
        return priceOfFood;
    }

    public void setPriceOfFood(double priceOfFood) {
        if (priceOfFood < 0) {
            System.out.println("Price cannot be negative. Setting to 0.");
            this.priceOfFood = 0;
        } else {
            this.priceOfFood = priceOfFood;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative. Setting to 0.");
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }

    public void updateFood(String name, double price) {
        this.nameOfFood = name;
        this.priceOfFood = price;
    }

    public void showFoodData() {
        System.out.printf("\nID: %d\nCountry: %s\nName: %s\nPrice: %.2f\nQuantity: %d\n",
                id, countryOfFood, nameOfFood, priceOfFood, quantity);
    }
}
