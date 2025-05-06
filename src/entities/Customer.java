package entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private AtomicInteger AutoCtId = new AtomicInteger(0);
    private String CtId;
    private String CtName;
    private String Username;
    private String TotalPriceCustomer;

    // Constructor
    public Customer(String ctName, String username, String totalPriceCustomer) {
        this.CtId = String.format("CtId%d", AutoCtId.incrementAndGet());
        this.CtName = ctName;
        this.Username = username;
        this.TotalPriceCustomer = totalPriceCustomer;
    }

    // Getters
    public String getCtId() {
        return CtId;
    }

    public String getCtName() {
        return CtName;
    }

    // Setters
    public void setCtName(String ctName) {
        CtName = ctName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getTotalPriceCustomer() {
        return TotalPriceCustomer;
    }

    public void setTotalPriceCustomer(String totalPriceCustomer) {
        TotalPriceCustomer = totalPriceCustomer;
    }

    // toString
    @Override
    public String toString() {
        return "Customer{" +
                "CtId='" + CtId + '\'' +
                ", CtName='" + CtName + '\'' +
                ", Username='" + Username + '\'' +
                ", TotalPriceCustomer='" + TotalPriceCustomer + '\'' +
                '}';
    }
}
