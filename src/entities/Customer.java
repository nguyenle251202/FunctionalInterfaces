package entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static final AtomicInteger AutoCtId = new AtomicInteger(0);
    private String CtId;
    private String CtName;
    private String Username;

    // Constructor
    public Customer(String ctName, String username) {
        this.CtId = String.format("Ct%d", AutoCtId.getAndIncrement());
        this.CtName = ctName;
        this.Username = username;
    }

    // Getters
    public String getCtId() {
        return CtId;
    }

    public String getCtName() {
        return CtName;
    }

    public String getUsername() {
        return Username;
    }

    // toString
    @Override
    public String toString() {
        return "Customer{" +
                "CtId='" + CtId + '\'' +
                ", CtName='" + CtName + '\'' +
                ", Username='" + Username + '\'' +
                '}';
    }
}
