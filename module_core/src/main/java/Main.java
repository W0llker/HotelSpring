
import dto.client.Address;
import dto.order.OrderRequest;
import dto.room.RoomType;
import itAcadamy.config.ConfigClass;
import dto.room.RoomRequest;


import itAcadamy.entity.*;
import itAcadamy.repository.*;
import itAcadamy.repository.hibernate.*;
import org.hibernate.proxy.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import itAcadamy.service.RoomService;
import service.HotelApi;
import service.RoomApi;


import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;


public class Main {
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigClass.class);
    public static void main(String[] args) {
        RoomApi roomApi = (RoomApi) applicationContext.getBean("roomService");
        System.out.println(roomApi.findById(1l));

//        ProxyFactory
        HotelApi hotelApi = applicationContext.getBean(HotelApi.class);
        OrderRequest orderRequest = new OrderRequest();
//        orderRequest.setHotelId(1l);
//        orderRequest.setClientId(1l);
        orderRequest.setStart(LocalDate.of(2020,10,20));
        orderRequest.setEnd(LocalDate.of(2021,10,20));
        hotelApi.bookRoom(orderRequest,RoomType.ONE);
//        addOrder();
//        addRoom();
        addClient();
    }
    private static void addOrder() {
//        RoomDao roomDao = new RoomHibernate();
//        ClientDao clientDao = new ClientHibernate();
//
//        OrderHotel orderHotel = new OrderHotel();
//        orderHotel.setOrderType(OrderType.BOOKING);
//        orderHotel.setHotel(roomDao.findById(1l).getHotel());
//        orderHotel.setClient(clientDao.findById(1l));
//        orderHotel.setRoom(roomDao.findById(1l));
//        orderHotel.setDateStart(LocalDate.of(2020,10,20));
//        orderHotel.setDateEnd(LocalDate.of(2021,10,20));
//        OrderDao orderDao = new OrderHibernate();
//        orderDao.add(orderHotel);
    }
    private static void addRoom() {
        HotelDao hotelDao = applicationContext.getBean(HotelDao.class);
        Room room = new Room();
        room.setNumber("2525");
        room.setPrice(new BigDecimal(255));
        room.setRoomType(RoomType.ONE);
        room.setHotel(hotelDao.findById(1l, Hotel.class));
        RoomDao roomDao = applicationContext.getBean(RoomDao.class);
        roomDao.add(room);
    }

    private static void addClient() {
        ClientDao clientDao = applicationContext.getBean(ClientDao.class);
        Address address = new Address();
        address.setCity("Гомель");
        address.setCountry("Беларусь");
        address.setStreet("Тамтам");
        address.setPostalCode("2025");

        Client client = new Client();
        client.setName("Никита");
        client.setLogin("Wolker");
        client.setSurName("Вдовенков");
        client.setPassword("1234");
        client.setClientStatus(ClientStatus.NORMAL);
        client.setMoneySpent(new BigDecimal(500));
        client.setDateOfBirth(LocalDate.now());
        client.setAddress(address);
        clientDao.add(client);
    }

    private static void addHotel() {
//        Address address = new Address();
//        address.setCity("Гомель");
//        address.setCountry("Беларусь");
//        address.setStreet("Тамтам");
//        address.setPostalCode("2025");
//
//        Hotel hotel = new Hotel();
//        hotel.setName("Гомельский отель");
//        hotel.setFloor(3);
//        hotel.setAddress(address);
//        HotelDao hotelDao = new HotelHibernate();
//        hotelDao.add(hotel);
    }

    private static Person addPerson() {
//        PersonDao personDao = new PersonHibernate();
//        Person person = new Person();
//        person.setName("Никита");
//        person.setSurName("Вдовенков");
//        person.setPost(Post.MANAGER);
//        person.setSalary(new BigDecimal(500));
//        person.setDateStart(LocalDate.now());
//        person.setDateEnd(null);
//        personDao.addPerson(9l, person);
//        return person;
        return null;
    }

    private static void addFeedBack() {
//        FeedBackDao feedBackDao = new FeedBackHibernate();
//        FeedBack feedBack = new FeedBack();
//        feedBack.setStars(2);
//        feedBack.setComment("Относительно неплохой отель");
//        feedBackDao.add(1l, feedBack);
    }

    private static void addAmenities() {
//        AmenitiesDao amenitiesDao = new AmenitiesHibernate();
//        Amenities amenities = new Amenities();
//        amenities.setName("Бассей");
//        amenities.setType(AmenitiesType.BATHROOM);
//        amenities.setPrice(new BigDecimal(500));
//        amenitiesDao.addAmenities(1l, amenities);
    }

    private static void addAdministration() {

    }
}
