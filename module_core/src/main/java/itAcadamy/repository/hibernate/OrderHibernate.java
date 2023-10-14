package itAcadamy.repository.hibernate;

import dto.room.RoomType;
import itAcadamy.config.ApplicationContext;
import itAcadamy.entity.OrderHotel;
import itAcadamy.repository.OrderDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Temporal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class OrderHibernate implements OrderDao {
    private final SessionFactory sessionFactory;
    private Transaction transaction;

    public OrderHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(OrderHotel order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editOrder(Long idOrder, OrderHotel order) {
// TODO: 14.10.2023
    }

    @Override
    public void deleteOrder(Long idOrder) {
// TODO: 14.10.2023
    }

    @Override
    public List<Long> getOrderInTheData(RoomType roomType, LocalDate start, LocalDate end) {
        Session session = sessionFactory.openSession();
        List<Long> longList = session.createQuery("select o.room.id from OrderHotel o where o.room.roomType=:type and o.dateStart between :start and :end or o.dateEnd between :start and :end ")
                .setParameter("start",start)
                .setParameter("type",roomType)
                .setParameter("end",end)
                .getResultList();
        return longList;
    }
}
