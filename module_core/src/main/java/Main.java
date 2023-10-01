
import entity.*;

import repository.HotelDao;
import repository.PersonDao;
import repository.hibernate.HotelHibernate;
import repository.hibernate.PersonHibernate;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
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

//        HotelDao hotelDao = new HotelHibernate();
//        Hotel hotel = new Hotel();
//        hotel.setName("Гомельскай гостиница");
//        hotel.setFloor(3);
//        hotel.setCountRoom(20);
//        hotel.setAddress(address);
//        Hotel hotel1 = hotelDao.findById(36l);
//        System.out.println(hotel1.getRoomList());
//        hotelDao.add(hotel);
//        hotelDao.delete(30l);

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
//        addHotel();
//        addPerson();
        PersonDao personDao = new PersonHibernate();
        System.out.println(personDao.findPersonNameAndSurName(9l,"Никита","Вдовенков"));
//        System.out.println(personDao.getPerson(9l));
//        System.out.println(personDao.getPersonPost(9l,Post.Manager));
    }

    private static void addClient() {

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
        person.setPost(Post.Manager);
        person.setSalary(new BigDecimal(500));
        person.setDateStart(LocalDate.now());
        person.setDateEnd(null);
        personDao.addPerson(9l,person);
        return person;
    }

    private static void addAdministration() {

    }
}
