// - Tìm 3 sản phẩm có doanh thu cao nhất
package services.imp;

import data.AllData;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import services.IHighestRevenue;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighestRevenueImp implements IHighestRevenue {
    public void TopThree() {
        List<Order> orders = AllData.getOrders(AllData.getProducts(), AllData.getCustomers());
        Consumer<List<Order>> ThreeProduct = orderList -> {
            orderList.stream()
                    .flatMap(order -> order.getOProducts().stream())
                    .collect(Collectors.groupingBy(OrderItem::getProduct,
                            Collectors.summingDouble(OrderItem::getPrice)))
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                    .limit(3)
                    .map(entry -> "Product: " + entry.getKey().getPdName() +
                            ", Total Revenue: " + entry.getValue())
                    .forEach(System.out::println);
        };
        ThreeProduct.accept(orders);
    }

    public static void main() {
        HighestRevenueImp hr = new HighestRevenueImp();
        hr.TopThree();
    }
}
