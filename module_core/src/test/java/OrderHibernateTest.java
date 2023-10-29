import dto.order.OrderRequest;
import dto.room.RoomType;
import itAcadamy.entity.Room;
import itAcadamy.mapper.HotelMapperImpl;
import itAcadamy.mapper.OrderMapperImpl;
import itAcadamy.repository.HotelDao;
import itAcadamy.repository.OrderDao;
import itAcadamy.repository.RoomDao;
import itAcadamy.repository.hibernate.HotelHibernate;
import itAcadamy.repository.hibernate.OrderHibernate;
import itAcadamy.repository.hibernate.RoomHibernate;
import itAcadamy.service.HotelService;
import org.junit.Test;
import service.HotelApi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderHibernateTest {
    private final OrderDao orderDao = new OrderHibernate();
    private final RoomDao roomDao = new RoomHibernate();
    private final HotelApi hotelApi = new HotelService(new HotelHibernate(), new RoomHibernate(), new OrderHibernate(), new HotelMapperImpl(), new OrderMapperImpl());
    @Test
    public void idOrder() {
        assertEquals(List.of(1L),orderDao.getOrderInTheData(RoomType.ONE, LocalDate.of(2020,10,20),LocalDate.of(2021,10,20)));
    }
    @Test
    public void testRoom() {
        HotelDao hotelDao = new HotelHibernate();
        Room room = new Room();
        room.setId(4l);
        room.setNumber("1234");
        room.setPrice(BigDecimal.valueOf(255.25));
        room.setRoomType(RoomType.ONE);
        room.setHotel(hotelDao.findById(1l));
        assertEquals(List.of(room),roomDao.getRoomNotIncludedIds(List.of(1L),RoomType.ONE,1l));
    }
    @Test
    public void order() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setHotelId(1l);
        orderRequest.setClientId(1l);
        orderRequest.setStart(LocalDate.of(2020,10,20));
        orderRequest.setEnd(LocalDate.of(2021,10,20));
        assertEquals(null,hotelApi.bookRoom(orderRequest,RoomType.ONE));
    }
}
