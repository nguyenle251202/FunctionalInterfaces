package entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private AtomicInteger AutoPdId = new AtomicInteger(0);
    private String PdId;
    private String PdName;
    private String Price;
    private String Quantity;

    // Constructor
    public Product(String pdName, String price, String quantity) {
        this.PdId = String.format("PdId%d", AutoPdId.incrementAndGet());
        this.PdName = pdName;
        this.Price = price;
        this.Quantity = quantity;
    }
    // Getters

    public String getPdId() {
        return PdId;
    }

    public String getPdName() {
        return PdName;
    }

    public void setPdName(String pdName) {
        PdName = pdName;
    }

    public String getPrice() {
        return Price;
    }
    // Setters

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
    // toString

    @Override
    public String toString() {
        return "Product{" +
                "PdId='" + PdId + '\'' +
                ", PdName='" + PdName + '\'' +
                ", Price='" + Price + '\'' +
                ", Quantity='" + Quantity + '\'' +
                '}';
    }
}
