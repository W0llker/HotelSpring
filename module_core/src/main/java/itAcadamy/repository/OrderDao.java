package itAcadamy.repository;

import dto.room.RoomType;
import itAcadamy.entity.OrderHotel;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends CrudOperation<OrderHotel>{

    List<Long> getOrderInTheData(RoomType roomType, LocalDate start,LocalDate end);
}
