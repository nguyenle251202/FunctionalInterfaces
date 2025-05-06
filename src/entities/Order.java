package entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private AtomicInteger AutoOId = new AtomicInteger(0);
    private String OId;
    private String OName;
    private String Date;
    private String TotalPriceOrder;

    // Constructor
    public Order(String oName, String date, String totalPriceOrder) {
        this.OId = String.format("OId%d", AutoOId.incrementAndGet());
        this.OName = oName;
        this.Date = date;
        this.TotalPriceOrder = totalPriceOrder;
    }
    // Getters

    public String getOId() {
        return OId;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public String getDate() {
        return Date;
    }
    // Setters

    public void setDate(String date) {
        Date = date;
    }

    public String getTotalPriceOrder() {
        return TotalPriceOrder;
    }

    public void setTotalPriceOrder(String totalPriceOrder) {
        TotalPriceOrder = totalPriceOrder;
    }
    // toString

    @Override
    public String toString() {
        return "Order{" +
                "OId='" + OId + '\'' +
                ", OName='" + OName + '\'' +
                ", Date='" + Date + '\'' +
                ", TotalPriceOrder='" + TotalPriceOrder + '\'' +
                '}';
    }
}
