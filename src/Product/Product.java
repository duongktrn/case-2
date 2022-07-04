package Product;

import java.io.Serializable;

public class Product implements Serializable {
    public int id;
    public Catolog name;
    public int amount;
    public double price;
    public static int count=0;

    public Product(Catolog name, int amount, double price) {
        id = ++count;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Catolog getName() {
        return name;
    }

    public void setName(Catolog name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Ma san pham=" + id +
                ", name=" + name +
                ", amont=" + amount +
                ", price=" + price +
                '}';
    }
}
