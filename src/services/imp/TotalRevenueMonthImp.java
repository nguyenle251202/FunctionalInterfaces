// tính tổng doanh thu mỗi tháng
package services.imp;

import data.AllData;
import entities.Order;
import services.ITotalRevenueMonth;

import java.util.List;
import java.util.function.Consumer;

public class TotalRevenueMonthImp implements ITotalRevenueMonth {
    public void calculateTotalRevenue(String month, String year) {
        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        Consumer<List<Order>> calculateAndPrintTotal = orderList -> {
            double totalPrice = orderList.stream()
                    .filter(order -> order.getMonthValue() == Integer.parseInt(month) && order.getYearValue() == Integer.parseInt(year))
                    .mapToDouble(Order::getOTotalPrice)
                    .sum();
            System.out.println("Total Price: " + totalPrice);
        };
        calculateAndPrintTotal.accept(orders);
    }

    public static void main(String[] args) {
        TotalRevenueMonthImp totalRevenueMonth = new TotalRevenueMonthImp();
        totalRevenueMonth.calculateTotalRevenue("02", "2020");
    }
}
