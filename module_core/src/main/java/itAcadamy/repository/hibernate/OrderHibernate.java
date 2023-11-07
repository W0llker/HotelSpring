package itAcadamy.repository.hibernate;

import dto.room.RoomType;
import itAcadamy.entity.OrderHotel;
import itAcadamy.repository.OrderDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//@Repository
//public class OrderHibernate extends  BaseCrudOperationHotel<OrderHotel> implements OrderDao {
//    @Autowired
//    public OrderHibernate(SessionFactory sessionFactory, Session session) {
//        super(sessionFactory, session);
//    }
//
//    @Override
//    public List<Long> getOrderInTheData(RoomType roomType, LocalDate start, LocalDate end) {
//        List<Long> longList = session.createQuery("select o.room.id from OrderHotel o where o.room.roomType=:type and o.dateStart between :start and :end or o.dateEnd between :start and :end ")
//                .setParameter("start", start)
//                .setParameter("type", roomType)
//                .setParameter("end", end)
//                .getResultList();
//        return longList;
//    }
//}
