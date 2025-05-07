package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger AutoOId = new AtomicInteger(0);
    private String OId;
    private LocalDate Date;
    private Customer OCustomer;
    private List<OrderItem> OProducts = new ArrayList<>();
    private double OTotalPrice;

    // Constructor

    public Order(String OId, LocalDate date, Customer OCustomer, List<OrderItem> OProducts) {
        this.OId = String.format("Order%d", AutoOId.getAndIncrement());
        this.Date = date;
        this.OCustomer = OCustomer;
        this.OProducts = OProducts;
    }

    public Order(String OId, LocalDate date, Customer oCustomer, OrderItem product, double OTotalPrice) {
        this.OId = String.format("Order%d", AutoOId.getAndIncrement());
        this.Date = LocalDate.parse(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.OCustomer = oCustomer;
        this.OProducts.add(product);
        this.OTotalPrice = OTotalPrice;
    }

    // Getters

    public String getOId() {
        return OId;
    }

    public String getDate() {
        return Date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public int getMonthValue() {
        return Integer.parseInt(Date.format(DateTimeFormatter.ofPattern("MM")));
    }

    public int getYearValue() {
        return Integer.parseInt(Date.format(DateTimeFormatter.ofPattern("yyyy")));
    }

    public Optional<Customer> getOCustomer() {
        return Optional.ofNullable(OCustomer);
    }

    public List<OrderItem> getOProducts() {
        return OProducts;
    }

public double getOTotalPrice() {
    return OProducts.stream().mapToDouble(OrderItem::getPrice).sum();
}

    // toString

    @Override
    public String toString() {
        return "Order{" +
                "OId='" + OId + '\'' +
                ", Date='" + Date + '\'' +
                ", OCustomer=" + getOCustomer().map(Customer::toString).orElse("N/A") +
                ", OProducts=" + OProducts +
                '}';
    }

    //
}
