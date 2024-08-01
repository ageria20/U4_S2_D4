package ageria;

import java.util.Random;

public class Product {

    Random random = new Random();
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.id = random.nextInt(10000, 20000);
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id=" + id +
                ", name ='" + name + '\'' +
                ", category ='" + category + '\'' +
                ", price =" + price;
    }
}
