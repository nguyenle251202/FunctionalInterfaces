package data;

import entities.Customer;
import entities.Order;
import entities.OrderItem;
import entities.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AllData {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static List<Product> Products = new ArrayList<>();
    public static List<Customer> Customers = new ArrayList<>();
    public static List<String> OrderItems = new ArrayList<>();
    public static List<Order> Orders = new ArrayList<>();

    public static List<Product> getProducts() {
        Products.add(new Product("Product0", 100));
        Products.add(new Product("Product1", 110));
        Products.add(new Product("Product2", 120));
        Products.add(new Product("Product3", 130));
        Products.add(new Product("Product4", 140));
        Products.add(new Product("Product5", 150));
        Products.add(new Product("Product6", 160));
        Products.add(new Product("Product7", 170));
        Products.add(new Product("Product8", 180));
        Products.add(new Product("Product9", 190));
        Products.add(new Product("Product10", 200));
        return Products;
    }

    public static List<Customer> getCustomers() {
        Customers.add(new Customer("Customer0", "customer0"));
        Customers.add(new Customer("Customer1", "customer1"));
        Customers.add(new Customer("Customer2", "customer2"));
        Customers.add(new Customer("Customer3", "customer3"));
        Customers.add(new Customer("Customer4", "customer4"));
        Customers.add(new Customer("Customer5", "customer5"));
        return Customers;
    }

    public static List<Order> getOrders(List<Product> products, List<Customer> customers) {
        Map<String, Product> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.put(product.getPdName(), product);
        }
        Orders.add(new Order("null", LocalDate.parse("01/01/2020", formatter), customers.get(0),
                List.of(new OrderItem(productMap.get("Product0"), 2), new OrderItem(productMap.get("Product1"), 3))));
        Orders.add(new Order("null", LocalDate.parse("03/01/2020", formatter), customers.get(1),
                List.of(new OrderItem(productMap.get("Product7"), 2), new OrderItem(productMap.get("Product2"), 4))));
        Orders.add(new Order("null", LocalDate.parse("05/01/2020", formatter), customers.get(3),
                List.of(new OrderItem(productMap.get("Product6"), 6), new OrderItem(productMap.get("Product3"), 1))));
        Orders.add(new Order("null", LocalDate.parse("06/01/2020", formatter), customers.get(1),
                List.of(new OrderItem(productMap.get("Product2"), 3))));
        Orders.add(new Order("null", LocalDate.parse("07/01/2020", formatter), customers.get(0),
                List.of(new OrderItem(productMap.get("Product1"), 3), new OrderItem(productMap.get("Product8"), 2),
                        new OrderItem(productMap.get("Product9"), 1))));
        Orders.add(new Order("null", LocalDate.parse("08/01/2020", formatter), customers.get(2),
                List.of(new OrderItem(productMap.get("Product0"), 4), new OrderItem(productMap.get("Product1"), 2))));
        Orders.add(new Order("null", LocalDate.parse("09/01/2020", formatter), customers.get(3),
                List.of(new OrderItem(productMap.get("Product8"), 2), new OrderItem(productMap.get("Product6"), 1))));
        Orders.add(new Order("null", LocalDate.parse("01/02/2020", formatter), customers.get(2),
                List.of(new OrderItem(productMap.get("Product1"), 2), new OrderItem(productMap.get("Product7"), 3))));
        Orders.add(new Order("null", LocalDate.parse("02/02/2020", formatter), customers.get(4),
                List.of(new OrderItem(productMap.get("Product6"), 5), new OrderItem(productMap.get("Product2"), 2))));
        Orders.add(new Order("null", LocalDate.parse("03/02/2020", formatter), customers.get(5),
                List.of(new OrderItem(productMap.get("Product0"), 3))));
        Orders.add(new Order("null", LocalDate.parse("04/02/2020", formatter), customers.get(1),
                List.of(new OrderItem(productMap.get("Product8"), 4), new OrderItem(productMap.get("Product3"), 2))));
        Orders.add(new Order("null", LocalDate.parse("05/02/2020", formatter), customers.get(0),
                List.of(new OrderItem(productMap.get("Product9"), 2))));
        Orders.add(new Order("null", LocalDate.parse("06/02/2020", formatter), customers.get(2),
                List.of(new OrderItem(productMap.get("Product1"), 6), new OrderItem(productMap.get("Product6"), 1))));
        Orders.add(new Order("null", LocalDate.parse("07/02/2020", formatter), customers.get(3),
                List.of(new OrderItem(productMap.get("Product5"), 3))));
        Orders.add(new Order("null", LocalDate.parse("01/03/2020", formatter), customers.get(4),
                List.of(new OrderItem(productMap.get("Product3"), 1), new OrderItem(productMap.get("Product10"), 2))));
        Orders.add(new Order("null", LocalDate.parse("02/03/2020", formatter), customers.get(5),
                List.of(new OrderItem(productMap.get("Product4"), 5), new OrderItem(productMap.get("Product7"), 2))));
        Orders.add(new Order("null", LocalDate.parse("03/03/2020", formatter), customers.get(0),
                List.of(new OrderItem(productMap.get("Product5"), 7))));
        Orders.add(new Order("null", LocalDate.parse("04/03/2020", formatter), customers.get(4),
                List.of(new OrderItem(productMap.get("Product3"), 6), new OrderItem(productMap.get("Product10"), 3))));
        Orders.add(new Order("null", LocalDate.parse("05/03/2020", formatter), customers.get(5),
                List.of(new OrderItem(productMap.get("Product0"), 5))));
        Orders.add(new Order("null", LocalDate.parse("06/03/2020", formatter), customers.get(2),
                List.of(new OrderItem(productMap.get("Product4"), 4))));
        Orders.add(new Order("null", LocalDate.parse("07/03/2020", formatter), customers.get(1),
                List.of(new OrderItem(productMap.get("Product6"), 2))));
        Orders.add(new Order("null", LocalDate.parse("07/03/2020", formatter), customers.get(1),
                List.of(new OrderItem(productMap.get("Product6"), 2))));
        return Orders;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getProducts();
        getCustomers();
        int n = -1;
        System.out.print("Enter Order: n = ");
        n = scanner.nextInt();
        getOrders(Products, Customers);
        System.out.println("\n [OrderId: " + Orders.get(n).getOId() + "] \n [OrderDate: " + Orders.get(n).getDate() + "] \n " +
                "[username: " + Orders.get(n).getOCustomer().get().getUsername() + "] \n "
                + Orders.get(n).getOProducts() + "\n => Total Price: " + Orders.get(n).getOTotalPrice());
    }
}
