public class Product {
    private final String name;
    private final double price;
    private int inBasket = 0;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Product(String name, double price, int inBasket) {
        this.name = name;
        this.price = price;
        this.inBasket = inBasket;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getInBasket() {
        return inBasket;
    }

    public void changeItemInBasket(int itemsNmb) {
        this.inBasket += itemsNmb;
    }

}