// - Tìm đơn hàng có giá trị lớn nhất của mỗi khách hàng
package services.imp;

import data.AllData;
import entities.Customer;
import entities.Order;
import services.IHighestOrderCustomer;
import services.IHighestRevenue;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class HighestOrderCustomerImp implements IHighestOrderCustomer {
    public void HighestRevenue() {
        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        Consumer<List<Order>> calculatePriceCustomer = orderList -> {
            for (Customer customer : AllData.getCustomers()) {
                Order maxOrder = orderList.stream()
                        .filter(order -> order.getOCustomer().isPresent()
                                && order.getOCustomer().get().getCtId().equals(customer.getCtId()))
                        .max((o1, o2) -> Double.compare(o1.getOTotalPrice(), o2.getOTotalPrice()))
                        .orElse(null);
                if (maxOrder != null) {
                    System.out.println("Username: " + customer.getUsername() + " => Max Price in Order: " + maxOrder.getOTotalPrice() + " => Order ID: " + maxOrder.getOId());
                } else {
                    System.out.println("Username: " + customer.getUsername() + " => No orders found.");
                }
            }
        };
        calculatePriceCustomer.accept(orders);
    }

    public static void main() {
        HighestOrderCustomerImp highestOrderCustomer = new HighestOrderCustomerImp();
        highestOrderCustomer.HighestRevenue();
    }
}
