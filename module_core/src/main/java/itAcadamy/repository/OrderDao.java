package itAcadamy.repository;

import dto.room.RoomType;
import itAcadamy.entity.OrderHotel;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao {
    void add(OrderHotel order);
    void editOrder(Long idOrder,OrderHotel order);
    void deleteOrder(Long idOrder);
    List<Long> getOrderInTheData(RoomType roomType, LocalDate start,LocalDate end);
}
