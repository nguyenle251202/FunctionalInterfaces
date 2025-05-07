// tính tổng doanh thu mỗi tháng
package services;

@FunctionalInterface
public interface ITotalRevenueMonth {
    double calculateTotalRevenue(String month, String year);
}
