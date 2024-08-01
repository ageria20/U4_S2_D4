package ageria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Andrea", 2);
        Customer customer2 = new Customer("Mirko", 1);
        Customer customer3 = new Customer("Antonio", 1);

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

        Order order1 = new Order("Pending", products, customer1);
        Order order2 = new Order("Confirmed", products, customer2);
        Order order3 = new Order("Shipped", products, customer3);
        List<Order> orderList = new ArrayList<>();

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

//        List<Product> orderProductsTier = orderList.stream()
//                .filter(order -> order.getCostumer().getTier() == 2 &&
//                        order.getOrderDate().isAfter(LocalDate.parse("2024-07-01")) &&
//                        order.getOrderDate().isBefore(LocalDate.parse("2024-08-01")))
//                .flatMap(order -> order.getProductList().stream()).toList();

        System.out.println("---------------------------------------ES1---------------------------------------");
        Map<Customer, List<Order>> orderCostumerList = orderList.stream().collect(Collectors.groupingBy(order -> order.getCustomer()));
        orderCostumerList.forEach((customer, orders) -> {
            System.out.println(customer);
            orders.forEach(order -> System.out.println(order));
        });
        System.out.println("---------------------------------------ES2---------------------------------------");
        Map<Customer, Double> totalPriceOrder = orderList.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(order -> order.getProductList().stream().mapToDouble(Product::getPrice).sum())));
        totalPriceOrder.forEach((customer, price) -> System.out.println(customer + ": " + "total spent:" + price));
        System.out.println("---------------------------------------ES3---------------------------------------");
        List<Product> expensiveItems = products.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toList();
        expensiveItems.forEach(item -> System.out.println(item));
        System.out.println("---------------------------------------ES4---------------------------------------");
        double averagePrice = orderList.stream()
                .collect(Collectors.averagingDouble(order -> order.getProductList().stream().collect(Collectors.averagingDouble(Product::getPrice))));
        System.out.println(averagePrice);
        System.out.println("---------------------------------------ES5---------------------------------------");
        Map<String, Double> sumCategoryProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));
        sumCategoryProducts.forEach((category, priceSum) -> System.out.println(category + ": " + priceSum));


    }
}
