// tính tổng doanh thu mỗi khách hàng
package services.imp;

import data.AllData;
import entities.Customer;
import entities.Order;

import java.util.List;

public class TotalRevenueCustomerImp {
    public static double TotalRevenueCustomer() {
        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        for (Customer customer : AllData.getCustomers()) {
            double revenue = orders.stream()
                    .filter(order -> order.getOCustomer().isPresent()
                            && order.getOCustomer().get().equals(customer))
                    .mapToDouble(Order::getOTotalPrice)
                    .sum();
            System.out.println("Username: " + customer.getUsername() + " => Revenue: " + revenue);
        }
        return 0;
    }
    public static void main(String[] args) {
        TotalRevenueCustomerImp totalRevenueCustomer = new TotalRevenueCustomerImp();
        totalRevenueCustomer.TotalRevenueCustomer();
    }
}

