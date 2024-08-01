package ageria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        Costumer costumer1 = new Costumer("Andrea", 2);
        Costumer costumer2 = new Costumer("Mirko", 1);
        Costumer costumer3 = new Costumer("Antonio", 1);

        Product book1 = new Product("Un senso di te", "book", 200);
        Product book2 = new Product("I miei superpoteri", "book", 10);
        Product biscotti = new Product("Plasmon", "baby", 3);
        Product latte = new Product("Vanigliato", "baby", 2);
        Product boysproduct = new Product("Tudor", "boys", 4000);
        Product boysproduct2 = new Product("MT-07", "boys", 7000);


        List<Product> products = new ArrayList<>();
        products.add(book1);
        products.add(book2);
        products.add(biscotti);
        products.add(latte);
        products.add(boysproduct);
        products.add(boysproduct2);

        Order order1 = new Order("Pending", products, costumer1);
        Order order2 = new Order("Confirmed", products, costumer2);
        Order order3 = new Order("Shipped", products, costumer3);
        List<Order> orderList = new ArrayList<>();

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        List<Product> orderProductsTier = orderList.stream()
                .filter(order -> order.getCostumer().getTier() == 2 &&
                        order.getOrderDate().isAfter(LocalDate.parse("2024-07-01")) &&
                        order.getOrderDate().isBefore(LocalDate.parse("2024-08-01")))
                .flatMap(order -> order.getProductList().stream()).toList();


        Map<Costumer, List<Order>> orderCostumerList = orderList.stream().collect(Collectors.groupingBy(order -> order.getCostumer()));
        orderCostumerList.forEach((costumer, order) -> System.out.println("Costumer: " + costumer + ", " + order));

        Map<Costumer, Double> totalPriceOrder = orderList.stream()
                .collect(Collectors.groupingBy(Order::getCostumer, Collectors.summingDouble(order -> order.getProductList().stream().mapToDouble(Product::getPrice).sum())));

        List<Double> expensiveItems = products.stream().filter(product -> product.getPrice() > )
    }
}
