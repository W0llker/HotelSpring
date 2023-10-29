import dto.order.OrderRequest;
import dto.room.RoomType;
import itAcadamy.config.ConfigClass;
import itAcadamy.entity.Hotel;
import itAcadamy.entity.Room;
import itAcadamy.repository.HotelDao;
import itAcadamy.repository.OrderDao;
import itAcadamy.repository.RoomDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.HotelApi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderHibernateTest {
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigClass.class);
    HotelApi hotelApi = applicationContext.getBean(HotelApi.class);
    private OrderDao orderDao = applicationContext.getBean(OrderDao.class);
    private HotelDao hotelDao = applicationContext.getBean(HotelDao.class);
    private RoomDao roomDao = applicationContext.getBean(RoomDao.class);

    @Test
    public void idOrder() {
        assertEquals(List.of(1L),orderDao.getOrderInTheData(RoomType.ONE, LocalDate.of(2020,10,20),LocalDate.of(2021,10,20)));
    }
    @Test
    public void testRoom() {
        Room room = new Room();
        room.setId(4l);
        room.setNumber("1234");
        room.setPrice(BigDecimal.valueOf(255.25));
        room.setRoomType(RoomType.ONE);
        room.setHotel(hotelDao.findById(1l, Hotel.class));
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
