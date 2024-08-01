package ageria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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


        List<Product> bookList = products.stream()
                .filter(product -> product.getCategory().equals("book") && product.getPrice() > 100)
                .toList();


        Order order1 = new Order("Pending", products, customer1);
        Order order2 = new Order("Confirmed", products, customer2);
        Order order3 = new Order("Shipped", products, customer3);
        List<Order> orderList = new ArrayList<>();

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);


        Predicate<Product> isBaby = product -> product.getCategory().equals("baby");
        List<Order> orders = orderList.stream()
                .filter(order -> order.getProductList().stream().anyMatch(isBaby))
                .toList();

        Predicate<Product> isBoys = product -> product.getCategory().equals("boys");
        List<Product> discountedProductsList = products.stream().filter(isBoys).toList();

        discountedProductsList.forEach(product -> {
            double discount = product.getPrice();
            product.setPrice(discount);
        });

        List<Product> orderProductsTier = orderList.stream()
                .filter(order -> order.getCustomer().getTier() == 2 &&
                        order.getOrderDate().isAfter(LocalDate.parse("2024-07-01")) &&
                        order.getOrderDate().isBefore(LocalDate.parse("2024-08-01")))
                .flatMap(order -> order.getProductList().stream()).toList();


        System.out.println(orderProductsTier);
//        System.out.println(orderList);

//        System.out.println(discountedProductsList);


    }
}