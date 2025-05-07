// tính tổng doanh thu mỗi tháng
package services.imp;

import data.AllData;
import entities.Order;
import services.ITotalRevenueMonth;

import java.util.List;

public class TotalRevenueMonthImp implements ITotalRevenueMonth {
    public static void main(String[] args) {
        ITotalRevenueMonth totalRevenueMonth = new TotalRevenueMonthImp();
        double total = totalRevenueMonth.calculateTotalRevenue("01", "2020");
        System.out.println("Total Revenue: " + total);
    }

    // Functional
    @Override
    public double calculateTotalRevenue(String month, String year) {
        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        double totalRevenue = orders.stream()
                .filter(order -> order.getMonthValue() == Integer.parseInt(month) && order.getYearValue() == Integer.parseInt(year))
                .mapToDouble(Order::getOTotalPrice)
                .sum();

        return totalRevenue;
    }
}
