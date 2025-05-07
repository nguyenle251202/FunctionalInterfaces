package entities;

public class OrderItem {
    private Product product;
    private double quantity;
    private double price;


    public OrderItem(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPdPrice() * quantity;
    }
    public double getPrice() {
        return price;
    }
    public Product getProduct() {
        return product;
    }
    public double getPdPrice() {
        return product.getPdPrice();
    }
    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
