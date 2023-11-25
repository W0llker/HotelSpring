package itAcadamy.repository;

import dto.order.OrderType;
import dto.room.RoomType;
import itAcadamy.entity.OrderHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends JpaRepository<OrderHotel, Long> {
    @Query("select r.id from OrderHotel o join o.room r where r.roomType=:roomType and o.dateStart between :start and :end or o.dateEnd between :start and :end")
    List<Long> getOrderInTheData(RoomType roomType, LocalDate start, LocalDate end);
    List<OrderHotel> getAllOrderByHotelId(Long idHotel);
    List<OrderHotel> getAllOrderByClientId(Long idClient);
    @Query("select o from OrderHotel o where o.orderType='PAID' or o.orderType='PAID_AND_LIFE'")
    List<OrderHotel> getAllOrderByOrderTypePaidOrPaidAndLife();
//    OrderHotel getOrderByOrderTypeAndClientId(OrderType orderType,Long clientId);
}
