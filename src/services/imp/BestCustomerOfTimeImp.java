// Tìm khách hàng chi tiêu nhiều nhất trong một khoảng thời gian
package services.imp;

import data.AllData;
import entities.Order;

import java.util.List;
import java.util.function.Consumer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Collections.min;
import static java.util.stream.Collectors.toList;

public class BestCustomerOfTimeImp {
    public void PeriodTime(LocalDate StartTime, LocalDate EndTime) {

        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        Consumer<List<Order>> calculateAndPrintTotal = orderList -> {
            //----------------------------------------------------------------------
            Order maxOrder = orderList.stream()
                    .filter(order ->
                            !LocalDate.parse(order.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(StartTime) &&
                                    !LocalDate.parse(order.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isAfter(EndTime))
                    .max((o1, o2) -> Double.compare(o1.getOTotalPrice(), o2.getOTotalPrice()))
                    .orElse(null);

            if (maxOrder != null) {
                System.out.println("Order ID: " + maxOrder.getOId() +
                        ", Order Date: " + maxOrder.getDate() +
                        ", Username: " + maxOrder.getOCustomer().get().getUsername() +
                        ", Total Price: " + maxOrder.getOTotalPrice());
            } else {
                System.out.println("No orders found in the specified time range.");
            }
            // -----------------------------------------------------------------------
//            List<Order> filteredOrders = (List<Order>) orderList.stream()
//                    .filter(order ->
//                            !LocalDate.parse(order.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(StartTime) &&
//                                    !LocalDate.parse(order.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isAfter(EndTime))
//                    .toList();
//            filteredOrders.forEach(order ->
//                    System.out.println("Order ID: " + order.getOId() +
//                            ", Order Date: " + order.getDate() +
//                            ", Username: " + order.getOCustomer().get().getUsername() +
//                            ", Total Price: " + order.getOTotalPrice()));
        };
        calculateAndPrintTotal.accept(orders);
    }

    public static void main() {
        BestCustomerOfTimeImp bestCustomerOfTime = new BestCustomerOfTimeImp();
        bestCustomerOfTime.PeriodTime(
                LocalDate.parse("06/01/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.parse("02/02/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
    }
}