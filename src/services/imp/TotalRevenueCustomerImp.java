// tính tổng doanh thu mỗi khách hàng
package services.imp;

import data.AllData;
import entities.Customer;
import entities.Order;

import java.util.List;

public class TotalRevenueCustomerImp {
    public static double TotalRevenueCustomer() {
        List<Customer> customers = AllData.getCustomers();
        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        double totalRevenue = 0;
        for (int i=0; i< customers.size(); i++) {
            System.out.print(customers.get(i).getUsername());

//            totalRevenue = orders.stream()
//                    .filter(orders.get())
//            System.out.print(" - Total Revenue: " + totalRevenue +"\n");
        }
        return totalRevenue;
    }
    public static void main(String[] args) {
        TotalRevenueCustomerImp totalRevenueCustomer = new TotalRevenueCustomerImp();
        TotalRevenueCustomer();
    }
}

