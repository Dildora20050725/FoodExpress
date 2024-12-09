public class Food {
    int id;
  String countryOfFood;
  String nameOfFood;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    double priceOfFood;

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
        this.priceOfFood = priceOfFood;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    int quantity;
    public void updateFood(String name, double price){
        this.nameOfFood = name;
        this.priceOfFood = price;
    }
    public Food(){
    }
    public Food(int id, String countryOfFood, String nameOfFood, double priceOfFood, int quantity) {
        this.id = id;
        this.countryOfFood = countryOfFood;
        this.nameOfFood = nameOfFood;
        this.priceOfFood = priceOfFood;
        this.quantity = quantity;
    }
    public void showFoodData(){
        System.out.printf("\nID: %s\nCountry: %s\nName: %s\nPrice: %s\nQuantity: %s", id, countryOfFood, nameOfFood, priceOfFood, quantity);
    }
}
