// - Phân loại đơn hàng theo tháng
package services.imp;

import data.AllData;
import entities.Order;

import java.util.List;
import java.util.function.Consumer;

public class CategorizeOrdersMonthImp {
    public void Categorize (String month, String year) {
        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        Consumer<List<Order>> calculateAndPrintTotal = orderList -> {
            List<Order> filteredOrders = orderList.stream()
                    .filter(order -> order.getMonthValue() == Integer.parseInt(month) && order.getYearValue() == Integer.parseInt(year))
                    .toList();
            filteredOrders.forEach(order ->
                    System.out.println("Order ID: " + order.getOId() +
                            ", Order Date: " + order.getDate() +
                            ", Username: " + order.getOCustomer().get().getUsername() +
                            ", Total Price: " + order.getOTotalPrice()));
        };
        calculateAndPrintTotal.accept(orders);
    }
    public static void main(String[] args) {
        CategorizeOrdersMonthImp categorizeOrdersMonth = new CategorizeOrdersMonthImp();
        categorizeOrdersMonth.Categorize("02", "2020");
    }
}
