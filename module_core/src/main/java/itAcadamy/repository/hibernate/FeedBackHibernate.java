package itAcadamy.repository.hibernate;

import itAcadamy.config.ApplicationContext;
import itAcadamy.entity.FeedBack;
import itAcadamy.entity.Hotel;
import itAcadamy.repository.FeedBackDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class FeedBackHibernate implements FeedBackDao {
    private final SessionFactory sessionFactory;

    public FeedBackHibernate() {
        sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Long hotelId, FeedBack feedBack) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Hotel hotel = (Hotel) session.createQuery("select h from Hotel h where h.id=:id")
                .setParameter("id", hotelId).getSingleResult();
        feedBack.setHotel(hotel);
//        feedBack.setClient();
        hotel.getFeedBacks().add(feedBack);
        session.persist(feedBack);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void edit(Long hotelId, Long feedBackId, FeedBack feedBack) {
        // TODO: 13.10.2023  
    }

    @Override
    public void delete(Long hotelId, Long feedBackId) {
        // TODO: 13.10.2023  
    }

    @Override
    public List<FeedBack> getFeedBackInHotelStars(Long hotelId, Integer stars) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<FeedBack> criteriaQuery = cb.createQuery(FeedBack.class);
        Root<FeedBack> root = criteriaQuery.from(FeedBack.class);
        Predicate predicate = cb.and(cb.equal(root.get("hotel"), hotelId),
                cb.ge(root.get("stars"), stars));
        criteriaQuery.select(root)
                .where(predicate);
        TypedQuery<FeedBack> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<FeedBack> getFeedBackInHotelUser(Long hotelId, Long UserId) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<FeedBack> criteriaQuery = cb.createQuery(FeedBack.class);
        Root<FeedBack> root = criteriaQuery.from(FeedBack.class);
        Predicate predicate = cb.and(cb.and(cb.equal(root.get("hotel"), hotelId)),
                cb.equal(root.get("client.id"), UserId));
        criteriaQuery.select(root)
                .where(predicate);
        TypedQuery<FeedBack> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<FeedBack> getFeedBackInHotel(Long hotelId) {
        DetachedCriteria detached = DetachedCriteria.forClass(FeedBack.class);
        detached.add(Restrictions.eq("hotel.id",hotelId));
        EntityManager entityManager = sessionFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = detached.getExecutableCriteria(session);
        return (List<FeedBack>) criteria.list();
    }
}
