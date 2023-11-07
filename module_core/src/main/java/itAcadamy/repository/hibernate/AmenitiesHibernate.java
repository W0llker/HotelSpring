package itAcadamy.repository.hibernate;

import itAcadamy.entity.Amenities;
import dto.amenities.AmenitiesType;
import itAcadamy.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import itAcadamy.repository.AmenitiesDao;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import java.util.List;

//@Repository
//public class AmenitiesHibernate extends BaseCrudOperationHotel<Amenities> implements AmenitiesDao {
//    @Autowired
//    public AmenitiesHibernate(SessionFactory sessionFactory, Session session) {
//        super(sessionFactory, session);
//    }
//
//    @Override
//    public List<Amenities> getAmenitiesByName(Long idHotel, String name) {
//        Query query = session.createQuery("select a from Amenities a where a.hotel.id=:id and a.name=:name");
//        query.setParameter("id", idHotel);
//        query.setParameter("name", name);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Amenities> getAmenitiesType(Long idHotel, AmenitiesType amenitiesType) {
//        Query query = session.createQuery("select a from Amenities a where a.hotel.id=:id and a.name=:type");
//        query.setParameter("id", idHotel);
//        query.setParameter("type", amenitiesType);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Amenities> getAmenities(Long idHotel) {
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Amenities> query = cb.createQuery(Amenities.class);
//        Root<Amenities> root = query.from(Amenities.class);
//        Join<Hotel, Amenities> join = root.join("hotel");
//        query.where(cb.equal(join.get("id"), idHotel));
//        return session.createQuery(query).getResultList();
//    }
//}
