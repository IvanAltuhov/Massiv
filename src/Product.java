import java.io.Serializable;

public class Product implements Serializable {
    private final String name;
    private final double price;
    private int inBasket = 0;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
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