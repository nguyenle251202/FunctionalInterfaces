// tính tổng doanh thu mỗi tháng
package services;

@FunctionalInterface
public interface ITotalRevenueMonth {
    void calculateTotalRevenue(String month, String year);
}
