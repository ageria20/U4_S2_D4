package ageria;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {

    Random random = new Random();
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> productList;
    private Costumer costumer;

    public Order(String status, List<Product> productList, Costumer costumer) {
        this.id = random.nextInt(10000, 20000);
        this.status = status;
        this.orderDate = LocalDate.now();
        this.deliveryDate = this.orderDate.plusDays(3);
        this.productList = productList;
        this.costumer = costumer;
    }


    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    @Override
    public String toString() {
        return "Order: " +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", productList=" + productList +
                ", costumer=" + costumer;
    }
}
