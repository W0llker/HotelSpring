package itAcadamy.repository.hibernate;

import itAcadamy.entity.FeedBack;
import itAcadamy.entity.Hotel;
import itAcadamy.repository.FeedBackDao;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

@Repository
public class FeedBackHibernate extends BaseCrudOperationHotel<FeedBack> implements FeedBackDao {
    @Autowired
    public FeedBackHibernate(SessionFactory sessionFactory, Session session) {
        super(sessionFactory, session);
    }

    @Override
    public List<FeedBack> getFeedBackInHotelStars(Long hotelId, Integer stars) {
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
        detached.add(Restrictions.eq("hotel.id", hotelId));
        EntityManager entityManager = sessionFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = detached.getExecutableCriteria(session);
        return (List<FeedBack>) criteria.list();
    }
}
