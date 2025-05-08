// tính tổng doanh thu mỗi khách hàng
package services.imp;

import data.AllData;
import entities.Customer;
import entities.Order;
import services.ITotalRevenueCustomer;

import java.util.List;
import java.util.function.Consumer;

public class TotalRevenueCustomerImp implements ITotalRevenueCustomer {

    public void TotalRevenueCustomer() {
        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        Consumer<List<Order>> calculatePriceCustomer = orderList -> {
            for (Customer customer : AllData.getCustomers()) {
                double totalPrice = orderList.stream()
                        .filter(order -> order.getOCustomer().isPresent() && order.getOCustomer().get().getCtId().equals(customer.getCtId()))
                        .mapToDouble(Order::getOTotalPrice)
                        .sum();
                System.out.println("Username: " + customer.getUsername() + " => Total Price: " + totalPrice);
            }
        };
        calculatePriceCustomer.accept(orders);
    }

    public static void main() {
        TotalRevenueCustomerImp totalRevenueCustomer = new TotalRevenueCustomerImp();
        totalRevenueCustomer.TotalRevenueCustomer();
    }
}

