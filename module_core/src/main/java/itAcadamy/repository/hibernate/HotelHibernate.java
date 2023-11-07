package itAcadamy.repository.hibernate;

import itAcadamy.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import itAcadamy.repository.HotelDao;

//@Repository
//public class HotelHibernate extends BaseCrudOperationHotel<Hotel> implements HotelDao {
//    @Autowired
//    public HotelHibernate(SessionFactory sessionFactory, Session session) {
//        super(sessionFactory, session);
//    }
//}
