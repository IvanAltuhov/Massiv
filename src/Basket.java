import java.io.*;
import java.util.Scanner;

public class Basket implements Serializable {
    private final Product[] goods;
    private double totalValue = 0;

    public Basket(Product[] goods) {
        this.goods = goods;
    }

    public void addToCart(int productNum, int amount) {
        goods[productNum].changeItemInBasket(amount);
        totalValue += goods[productNum].getPrice() * amount;
    }

    public void printGoodsList() {

        System.out.print(" №       Название   Цена за шт.     В корзине        Стоимость\n" + "");

        double currentValue;
        totalValue = 0;
        for (int i = 0; i < goods.length; i++) {
            currentValue = goods[i].getInBasket() * goods[i].getPrice();
            totalValue += currentValue;
            System.out.printf("%2d. %13s %12.2f %10d %17.2f\n", i + 1,
                    goods[i].getName(), goods[i].getPrice(),
                    goods[i].getInBasket(), currentValue);
        }
        System.out.printf("ИТОГО Товаров в корзине на %10.2f\n\n", totalValue);
        System.out.print("""
                Добавьте товар в корзину  (№ и количество<ENTER>).
                Для завершения работы введите <end>.
                """);
    }

    public void printCart() {
        System.out.print("Ваша корзина:\n");
        for (Product item : goods) {
            if (item.getInBasket() > 0) {
                System.out.printf("%13s %3d шт. %6.2f руб/шт. %8.2f в сумме\n",
                        item.getName(), item.getInBasket(), item.getPrice(),
                        item.getInBasket() * item.getPrice());
            }
        }
        System.out.printf("ИТОГО Товаров в корзине на %10.2f\n\n", totalValue);
    }

    public void saveBin(File file) throws IOException {
        var fos = new FileOutputStream(file);
        var oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

    public static Basket loadFromBinFile(File file) throws IOException, ClassNotFoundException {
        var fis = new FileInputStream(file);
        var ois = new ObjectInputStream(fis);
        return (Basket) ois.readObject();
    }
}