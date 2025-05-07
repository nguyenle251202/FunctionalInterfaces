package entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger AutoPdId = new AtomicInteger(0);
    private String PdId;
    private String PdName;
    private double PdPrice;

    // Constructor
    public Product(String pdName, double pdprice) {
        this.PdId = String.format("Pd%d", AutoPdId.getAndIncrement());
        this.PdName = pdName;
        this.PdPrice = pdprice;
    }
    // Getters

    public String getPdId() {
        return PdId;
    }

    public String getPdName() {
        return PdName;
    }

    public double getPrice() {
        return PdPrice;
    }

    // toString

    @Override
    public String toString() {
        return "Product{" +
                "PdId='" + PdId + '\'' +
                ", PdName='" + PdName + '\'' +
                ", PdPrice='" + PdPrice + '\'' +
                '}';
    }
}
