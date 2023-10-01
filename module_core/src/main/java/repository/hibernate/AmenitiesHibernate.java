package repository.hibernate;

import config.ApplicationContext;
import entity.Amenities;
import entity.AmenitiesType;
import entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.AmenitiesDao;

import javax.persistence.Query;
import java.util.List;

public class AmenitiesHibernate implements AmenitiesDao {
    private SessionFactory sessionFactory;

    public AmenitiesHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void addAmenities(Long idHotel, Amenities amenities) {
        Session session = sessionFactory.openSession();
        session.beginTransaction().begin();
        Hotel hotel = session.get(Hotel.class,idHotel);
        hotel.getAmenitiesList().add(amenities);
        amenities.setHotel(hotel);
        session.persist(amenities);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAmenities(Long idHotel, Long idAmenities) {

    }

    @Override
    public void update(Long idHotel, Long idAmenities, Amenities amenities) {

    }

    @Override
    public List<Amenities> getAmenitiesByName(Long idHotel, String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select a from Amenities a where a.hotel.id=:id and a.name=:name");
        query.setParameter("id",idHotel);
        query.setParameter("name",name);
        return query.getResultList();
    }

    @Override
    public List<Amenities> getAmenitiesType(Long idHotel, AmenitiesType amenitiesType) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select a from Amenities a where a.hotel.id=:id and a.name=:type");
        query.setParameter("id",idHotel);
        query.setParameter("type",amenitiesType);
        return query.getResultList();
    }

    @Override
    public List<Amenities> getAmenities(Long idHotel) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select a from Amenities a where a.hotel.id=:id");
        query.setParameter("id",idHotel);
        return query.getResultList();
    }
}
