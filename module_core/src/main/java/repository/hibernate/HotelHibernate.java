package repository.hibernate;

import config.ApplicationContext;
import entity.Amenities;
import entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.HotelDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class HotelHibernate implements HotelDao {
    private final SessionFactory sessionFactory;

    public HotelHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Hotel hotel) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(hotel);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Hotel hotel = session.find(Hotel.class, id);
        session.delete(hotel);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Long id, Hotel hotel) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        hotel.setId(id);
        session.update(hotel);
        session.getTransaction().commit();
    }

    @Override
    public Hotel findById(Long id) {
        Session session = sessionFactory.openSession();
        Hotel hotel = session.find(Hotel.class, id);
        return hotel;
    }
}
