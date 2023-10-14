package itAcadamy.repository.hibernate;

import itAcadamy.config.ApplicationContext;
import itAcadamy.entity.Amenities;
import itAcadamy.entity.AmenitiesType;
import itAcadamy.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import itAcadamy.repository.AmenitiesDao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class AmenitiesHibernate implements AmenitiesDao {
    private SessionFactory sessionFactory;

    public AmenitiesHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void addAmenities(Long idHotel, Amenities amenities) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Hotel hotel = session.get(Hotel.class,idHotel);
        hotel.getAmenitiesList().add(amenities);
        amenities.setHotel(hotel);
        session.persist(amenities);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAmenities(Long idHotel, Long idAmenities) {
        // TODO: 13.10.2023  
    }

    @Override
    public void update(Long idHotel, Long idAmenities, Amenities amenities) {
        // TODO: 13.10.2023  
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
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Amenities> query = cb.createQuery(Amenities.class);
        Root<Amenities> root = query.from(Amenities.class);
        Join<Hotel,Amenities> join = root.join("hotel");
        query.where(cb.equal(join.get("id"),idHotel));
        return session.createQuery(query).getResultList();
    }
}
