
import dto.room.RoomRequest;
import entity.*;

import mapper.RoomMapper;
import repository.*;
import repository.hibernate.*;
import service.RoomService;

import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        RoomRequest roomRequest = new RoomRequest();
//        roomRequest.setNumber("20А");
//        roomRequest.setSize(2);
//        roomRequest.setFloor(3);
//        roomRequest.setPrice(new BigDecimal(300));
//        RoomApi roomApi = new RoomService(new RoomHibernate(), new HotelHibernate(), new RoomMapper());
//        roomApi.add(36l,roomRequest);


//        RoomDao roomDao = new RoomHibernate();
//        Room room = roomDao.findById(41l);
//        System.out.println(room.getHotel());

//        ClientDao clientDao = new ClientHibernate();
//        clientDao.add(client);
//        clientDao.delete(16l);
//        User client1 = clientDao.findById(16l);
//        System.out.println(client1);

//        addClient();
//        ClientDao clientDao = new ClientHibernate();
//        System.out.println(clientDao.findById(1l));
//        System.out.println(clientDao.getAllClientStatus(ClientStatus.STANDART));


//        addHotel();
//        addPerson();
//        addHotel();
//        addRoom();
        RoomDao roomDao = new RoomHibernate();
        System.out.println(roomDao.getRoomByType(1l,RoomType.ONE));
        System.out.println(roomDao.findById(1l));
//        addFeedBack();

//        FeedBackDao feedBackDao = new FeedBackHibernate();
//        System.out.println(feedBackDao.getFeedBackInHotel(1l));
//        System.out.println(feedBackDao.getFeedBackInHotelStars(1l,3));


//        addAmenities();
//        AmenitiesDao amenitiesDao = new AmenitiesHibernate();
//        System.out.println(amenitiesDao.getAmenities(1l));


//        PersonDao personDao = new PersonHibernate();
//        System.out.println(personDao.findPersonNameAndSurName(9l,"Никита","Вдовенков"));
//        System.out.println(personDao.getPerson(9l));
//        System.out.println(personDao.getPersonPost(9l,Post.Manager));
    }

    private static void addRoom() {
        RoomRequest room = new RoomRequest();
        room.setPrice(new BigDecimal(500));
        room.setNumber("213");
        room.setPrice(new BigDecimal(500));
        room.setFloor(3);
        RoomService roomService = new RoomService(new RoomHibernate(),new HotelHibernate(),new RoomMapper());
        roomService.add(1l,room);
    }

    private static void addClient() {
        ClientDao clientDao = new ClientHibernate();
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
        Address address = new Address();
        address.setCity("Гомель");
        address.setCountry("Беларусь");
        address.setStreet("Тамтам");
        address.setPostalCode("2025");

        Hotel hotel = new Hotel();
        hotel.setName("Гомельский отель");
        hotel.setFloor(3);
        hotel.setAddress(address);
        HotelDao hotelDao = new HotelHibernate();
        hotelDao.add(hotel);
    }

    private static Person addPerson() {
        PersonDao personDao = new PersonHibernate();
        Person person = new Person();
        person.setName("Никита");
        person.setSurName("Вдовенков");
        person.setPost(Post.MANAGER);
        person.setSalary(new BigDecimal(500));
        person.setDateStart(LocalDate.now());
        person.setDateEnd(null);
        personDao.addPerson(9l, person);
        return person;
    }

    private static void addFeedBack() {
        FeedBackDao feedBackDao = new FeedBackHibernate();
        FeedBack feedBack = new FeedBack();
        feedBack.setStars(2);
        feedBack.setComment("Относительно неплохой отель");
        feedBackDao.add(1l, feedBack);
    }

    private static void addAmenities() {
        AmenitiesDao amenitiesDao = new AmenitiesHibernate();
        Amenities amenities = new Amenities();
        amenities.setName("Бассей");
        amenities.setType(AmenitiesType.BATHROOM);
        amenities.setPrice(new BigDecimal(500));
        amenitiesDao.addAmenities(1l, amenities);
    }

    private static void addAdministration() {

    }
}
